# dict, with count of chars
# no more than 3 different chars, or sum of count of two lesser chars: c1 + c2 + c3 - max(c1,c2,c3) <= k
#
class Solution(object):
    def characterReplacement(self, s, k):
        window_start = 0
        chars = {}
        result = 0
        max_repeat = 0

        for window_end, c in enumerate(s):
            if c not in chars:
                chars[c] = 0
            chars[c] += 1
            max_repeat = max(max_repeat, chars[c])

            while window_end - window_start + 1 - max_repeat > k:
                left_char = s[window_start]
                chars[left_char] -= 1
                if chars[left_char] == 0:
                    del chars[left_char]
                window_start += 1

            result = max(result, window_end - window_start + 1)

        return result


print(Solution().characterReplacement('AABABBA', 1))
print(Solution().characterReplacement('aabccbb', 2))
print(Solution().characterReplacement('abbcb', 1))
print(Solution().characterReplacement('abccde', 1))
