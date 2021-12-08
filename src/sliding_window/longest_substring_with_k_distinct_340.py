# check if len(dict) >= k
# remove window start chars until len less than k, decrement count in dict, remove if 0
# add char if not in dict add it
# calculate max
class Solution(object):
    def lengthOfLongestSubstringKDistinct(self, s, k):
        window_start = 0
        char_frequency = {}
        max_length = 0
    
        for window_end in range(len(s)):
            right_char = s[window_end]
            if right_char not in char_frequency:
                char_frequency[right_char] = 0
            char_frequency[right_char] += 1
    
            while len(char_frequency) > k:
                left_char = s[window_start]
    
                char_frequency[left_char] -= 1
                if char_frequency[left_char] == 0:
                    del char_frequency[left_char]
    
                window_start += 1
    
            max_length = max(max_length, window_end - window_start + 1)
    
        return max_length


print(Solution().lengthOfLongestSubstringKDistinct('araaci', 2))  # 4
print(Solution().lengthOfLongestSubstringKDistinct('araaci', 1))  # 2
print(Solution().lengthOfLongestSubstringKDistinct('cbbebi', 3))  # 5
print(Solution().lengthOfLongestSubstringKDistinct('cbbebi', 10))  # 6
