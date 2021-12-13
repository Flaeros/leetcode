from typing import List


# 1. sort, and check old and sorted arrays nlogn
# 2. check words by pairs via compare function n

class Solution:
    def isAlienSorted(self, words: List[str], order: str) -> bool:
        if len(words) < 2:
            return True

        orderd = {}
        for i, c in enumerate(order):
            orderd[c] = i

        for i in range(1, len(words)):
            if not self.inOrder(words[i - 1], words[i], orderd):
                return False

        return True

    def inOrder(self, first, second, order):
        limit = min(len(first), len(second))

        for i in range(limit):
            if order[first[i]] > order[second[i]]:
                return False
            elif order[first[i]] < order[second[i]]:
                return True

        if len(first) > len(second):
            return False

        return True


print(Solution().isAlienSorted(words=["hello", "leetcode"], order="hlabcdefgijkmnopqrstuvwxyz"))
print(Solution().isAlienSorted(words=["word", "world", "row"], order="worldabcefghijkmnpqstuvxyz"))
print(Solution().isAlienSorted(words=["apple", "app"], order="abcdefghijklmnopqrstuvwxyz"))
