from typing import List


class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        stack = []

        def calculate(left, right, token):
            if token == '+':
                return left + right
            elif token == '-':
                return left - right
            elif token == '*':
                return left * right
            elif token == '/':
                return int(float(left) / float(right))

        for token in tokens:
            if token in ('+', '-', '*', '/'):
                right = int(stack.pop())
                left = int(stack.pop())
                stack.append(calculate(left, right, token))
            else:
                stack.append(token)

        return stack[-1]



# 22
print(Solution().evalRPN(["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]))
# 9
print(Solution().evalRPN(["2", "1", "+", "3", "*"]))