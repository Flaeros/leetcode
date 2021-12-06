# two pointers

# bruteforce
# for each index, for each from i -> which length, unique symbols in map/dict O(n^2)

# iterate (n)
# c not in dict -> add, move high, increment current, update result
# c in dict -> while c != string[low], decrement current, increment low, remove string[low] from set
# return result


class Solution(object):
    def lengthOfLongestSubstring(self, sequence):
        dict = set()
        result = 0
        window_start = 0

        for window_end, c in enumerate(sequence):
            if c in dict:
                while c != sequence[window_start]:
                    dict.remove(sequence[window_start])
                    window_start += 1

                if c == sequence[window_start]:
                    window_start += 1

            if c not in dict:
                dict.add(c)
                result = max(result, window_end - window_start  + 1)

        return result


# map = a,b,c
# low = 0
# high = 3
# max = 3
# current = 3

print(Solution().lengthOfLongestSubstring("hhtekvlurjuufladcd"))  # 3
print(Solution().lengthOfLongestSubstring("abcabcbb"))  # 3
print(Solution().lengthOfLongestSubstring("abcbbcbb"))  # 3
print(Solution().lengthOfLongestSubstring("dvdf"))  # 3
print(Solution().lengthOfLongestSubstring("bbbbb"))  # 3
print(Solution().lengthOfLongestSubstring("pwwkew"))  # 3
print(Solution().lengthOfLongestSubstring("aab"))  # 3
print(Solution().lengthOfLongestSubstring("bbtablud"))  # 3
print(Solution().lengthOfLongestSubstring("abba"))  # 3

# "abcbbcbb" - 3
# "dvdf" - 3
# "abcabcbb" - 3
# "bbbbb" - 1
# "pwwkew" - 3
# "" - 0
# "aab" - 2
# "bbtablud" - 6
# "abba" - 2
