# from left to right:
# keep track of two subsequences:
# one that starts with 0s and ends with 1s, like 000111 - zeros
# second that starts with 1s and ends with 0s, like 111000 - ones
# if zeroes encounter 0 after 1, or 1s > 0s - break and calculate all possible sequences (for length/2)
# if ones encounter 1 after 0,   or 0s > 1s - break and calculate all possible sequences (for length/2)

class Solution:
    def countBinarySubstrings(self, s):
        result, ones, zeros = 0, 0, 0

        prev = None
        for c in s:
            if c == '0':
                if prev is not None and prev == '1' and zeros > 0:
                    result += min(zeros, ones)
                    zeros = 1
                else:
                    zeros += 1
                prev = '0'
            else:
                if prev is not None and prev == '0' and ones > 0:
                    result += min(zeros, ones)
                    ones = 1
                else:
                    ones += 1
                prev = '1'

        result += min(zeros, ones)
        return result


print(Solution().countBinarySubstrings("00110011"))
print(Solution().countBinarySubstrings("10101"))
