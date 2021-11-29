# %2!=0 -> false

# 1 opening ->  arr
# 2 closing -> prev & current with format
# 3 arr empty & next closing -> false
# 4 arr -> empty

class Solution(object):
    def valid_parenthesis(self, str):
        n = len(str)

        pairs = {']': '[', ')': '(', '}': '{'}

        if n == 0:
            return True

        if n % 2 != 0:
            return False

        stack = []

        for s in str:
            if s == ']' or s == ')' or s == '}':
                if len(stack) == 0:
                    return False
                prev = stack.pop()
                if prev != pairs[s]:
                    return False
            elif s == '[' or s == '(' or s == '{':
                stack.append(s)

        return True if len(stack) == 0 else False


print(Solution().valid_parenthesis(("(]")))
print(Solution().valid_parenthesis(("()[]{}")))
print(Solution().valid_parenthesis(("([)]")))
print(Solution().valid_parenthesis(("(")))
print(Solution().valid_parenthesis(("]")))
print(Solution().valid_parenthesis(("[]")))
print(Solution().valid_parenthesis(("[({")))
