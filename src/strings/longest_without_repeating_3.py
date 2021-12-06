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
        current = 0
        low, high = 0, 0

        for c in sequence:
            high += 1
            if c not in dict:
                dict.add(c)
                current += 1
                result = max(result, current)
            else:
                while c != sequence[low] and low < high:
                    dict.remove(sequence[low])
                    current -= 1
                    low += 1

                if c == sequence[low]:
                    low += 1

        return result

# map = a,b,c
# low = 0
# high = 3
# max = 3
# current = 3

print(Solution().lengthOfLongestSubstring("hhtekvlurjuufladcd")) #3
print(Solution().lengthOfLongestSubstring("abcabcbb")) #3
print(Solution().lengthOfLongestSubstring("abcbbcbb")) #3
print(Solution().lengthOfLongestSubstring("dvdf")) #3
print(Solution().lengthOfLongestSubstring("bbbbb")) #3
print(Solution().lengthOfLongestSubstring("pwwkew")) #3
print(Solution().lengthOfLongestSubstring("aab")) #3
print(Solution().lengthOfLongestSubstring("bbtablud")) #3
print(Solution().lengthOfLongestSubstring("abba")) #3



# "abcbbcbb" - 3
# "dvdf" - 3
# "abcabcbb" - 3
# "bbbbb" - 1
# "pwwkew" - 3
# "" - 0
# "aab" - 2
# "bbtablud" - 6
# "abba" - 2
