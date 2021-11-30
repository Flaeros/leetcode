class Solution(object):
    def minRemoveToMakeValid(self, s):
        intermediate = ""
        stack = []
        for c in s:
            if c == '(':
                stack.append(c)
                intermediate += c
            elif c == ')':
                if len(stack) > 0:
                    prev = stack.pop()
                    if prev == '(':
                        intermediate += c
            else:
                intermediate += c

        stack = []

        result = ""
        for c in reversed(intermediate):
            if c == ')':
                stack.append(c)
                result += c
            elif c == '(':
                if len(stack) > 0:
                    prev = stack.pop()
                    if prev == ')':
                        result += c
            else:
                result += c

        return result[::-1]


print(Solution().minRemoveToMakeValid("lee(t(c)o)de)"))
print(Solution().minRemoveToMakeValid("a)b(c)d"))
print(Solution().minRemoveToMakeValid("))(("))
print(Solution().minRemoveToMakeValid("(a(b(c)d)"))
