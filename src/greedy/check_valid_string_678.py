# checking balance
# low - sum ( and minus *), cant be <0
# high - sum (* and minus )
# if high < 0 False
# if low == 0 True else False
class Solution(object):
    def checkValidString(self, s):
        low, high = 0, 0

        for c in s:
            if c == '(':
                low += 1
                high += 1
            elif c == ')':
                low -= 1
                high -= 1
            else:
                low -= 1
                high += 1

            if high < 0:
                print(f'high={high}')
                return False

            if low < 0:
                low = 0

        print(f'low={low}')
        return low == 0


print(True, Solution().checkValidString("(((*)"))
print(True, Solution().checkValidString("(***)"))
print(True, Solution().checkValidString("()"))
print(True, Solution().checkValidString("(*)"))
print(True, Solution().checkValidString("(*))"))
print(False, Solution().checkValidString("())"))
print(False, Solution().checkValidString("*))"))
