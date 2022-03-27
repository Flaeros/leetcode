class Solution:
    _end_ = '_end_'

    def findAllConcatenatedWordsInADict(self, words):
        words = sorted(words, key=lambda x: len(x))

        trie = {}
        result = []
        for word in words:
            if self.exists_concatenated(trie, word, 0):
                result.append(word)
            self.append_trie(trie, word)

        return result

    # dfs + repeat
    # 1. traverse word and trie, find existing word
    # 2. if not found end in trie, return false
    # 3. if found end in trie:
    # 3.1 if word ended, 1 word, return false
    # 3.2 if word not ended, start from the top of the trie
    # 3.2.1 if found end in trie and if word ended, >1 word, return true
    # repeat for all matches

    def exists_concatenated(self, trie, word, matches):
        current = trie

        for i in range(len(word)):
            if word[i] in current:
                if self.exists_concat_rec(trie, current, word, i, matches):
                    return True
                else:
                    current = current[word[i]]

        return False

    def exists_concat_rec(self, trie, current, word, i, matches):
        if self._end_ in current:
            matches += 1
            if i == len(word) - 1:
                if matches > 1:
                    return True
                else:
                    return False

            if self.exists_concatenated(trie, word[i:], matches):
                return True

    def append_trie(self, trie, word):
        current = trie
        for char in word:
            current = current.setdefault(char, {})

        current[self._end_] = self._end_

        return trie


print(Solution().findAllConcatenatedWordsInADict(["cat", "dog", "catdog"]))
print(Solution().findAllConcatenatedWordsInADict(
    ["cat", "cats", "catsdogcats", "dog", "dogcatsdog", "hippopotamuses", "rat", "ratcatdogcat"]))
