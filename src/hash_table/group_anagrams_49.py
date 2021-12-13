from typing import List


# 0. nklogk - sorting, nk space
# 1. nk - hash
# 2. nk - identity by 26x vector n*k time, n*k space

def get_vector(str):
    vector = [0] * 26

    for c in str:
        index = ord(c) - ord('a')
        vector[index] += 1

    return tuple(vector)


class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        result = []
        dict = {}  # vector: [strings] # abc, bca

        for str in strs:
            vector = get_vector(str)
            value = dict.get(vector, [])
            value.append(str)
            dict[vector] = value

        for arr in dict.values():
            result.append(arr)

        return result

print(Solution().groupAnagrams(["eat", "tea", "tan", "ate", "nat", "bat"]))
