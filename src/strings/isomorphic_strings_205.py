class Solution(object):
    def isIsomorphic(self, s, t):
        return self.get_hash(s) == self.get_hash(t)

    def get_hash(self, s):
        cache = {}
        num = 0

        result = []
        for c in s:
            if c not in cache:
                cache[c] = num
                num += 1
            result.append(cache[c])

        return result


print(Solution().isIsomorphic(s="egg", t="add"))
print(Solution().isIsomorphic(s="foo", t="bar"))
print(Solution().isIsomorphic(s="paper", t="title"))
