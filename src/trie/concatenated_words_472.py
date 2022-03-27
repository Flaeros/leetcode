class Solution:

    def findAllConcatenatedWordsInADictDfs(self, words):
        result = []
        parts = set()
        words.sort(key=len)
        memo = set()

        for word in words:
            if self.exists_dfs(parts, word, memo):
                result.append(word)
            parts.add(word)

        return result

    # dfs
    # space N + K
    # time N * 2^K
    def exists_dfs(self, parts, word, memo):
        if word in memo:
            return True

        for i in range(len(word)):
            prefix = word[i:]
            suffix = word[:i]

            if prefix in parts and suffix in parts:
                memo.add(word)
                return True
            if prefix in parts and (suffix in memo or self.exists_dfs(parts, suffix, memo)):
                return True
            if suffix in parts and (prefix in memo or self.exists_dfs(parts, prefix, memo)):
                return True

        return False


    def findAllConcatenatedWordsInADict(self, words):
        result = []
        parts = set()
        words.sort(key=len)

        for word in words:
            if self.exists(parts, word):
                result.append(word)
            parts.add(word)

        return result


    # dp
    # time N*K^2
    # space K
    def exists(self, parts, word):
        if not parts:
            return False
        n = len(word)
        dp = [False] * (n + 1)
        dp[0] = True

        for i in range(0, n):
            for j in range(i, n + 1):
                if word[i:j] in parts and dp[i]:
                    dp[j] = True

        return dp[-1]


print(Solution().findAllConcatenatedWordsInADict([""]))
print(Solution().findAllConcatenatedWordsInADict(["cat", "dog", "catdog"]))
print(Solution().findAllConcatenatedWordsInADict(
    ["cat", "cats", "catsdogcats", "dog", "dogcatsdog", "hippopotamuses", "rat", "ratcatdogcat"]))


print(Solution().findAllConcatenatedWordsInADictDfs(["cat", "dog", "catdog"]))
print(Solution().findAllConcatenatedWordsInADictDfs(
    ["cat", "cats", "catsdogcats", "dog", "dogcatsdog", "hippopotamuses", "rat", "ratcatdogcat"]))
