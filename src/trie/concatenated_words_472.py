class Solution:

    def findAllConcatenatedWordsInADict(self, words):
        result = []
        parts = set()
        words.sort(key=len)

        for word in words:
            if self.exists_dp(parts, word):
                result.append(word)
            parts.add(word)

        return result

    # dfs
    def exists_dfs(self, parts, word):
        for i in range(len(word)):
            prefix = word[i:]
            suffix = word[:i]

            if prefix in parts and suffix in parts:
                return True
            if prefix in parts and self.exists_dfs(parts, suffix):
                return True
            if suffix in parts and self.exists_dfs(parts, prefix):
                return True

        return False

    def exists_dp(self, parts, word):
        n = len(word)
        dp = [False] * (n + 1)
        dp[0] = True

        for i in range(0, n):
            for j in range(i, n + 1):
                if word[i:j] in parts and dp[i]:
                    dp[j] = True

        return dp[-1]


print(Solution().findAllConcatenatedWordsInADict(["cat", "dog", "catdog"]))
print(Solution().findAllConcatenatedWordsInADict(
    ["cat", "cats", "catsdogcats", "dog", "dogcatsdog", "hippopotamuses", "rat", "ratcatdogcat"]))
