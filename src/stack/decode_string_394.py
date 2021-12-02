# if != ']' -> push to stack
# if [ -> pop from stack
# if char - append temp string
# if [ skip
# if number - multiply and append string


class Solution(object):
    def decodeString(self, s):
        result = ""
        stack = []

        for c in s:
            if c != ']':
                stack.append(c)
            else:
                temp = ""
                digit = ""
                while stack[-1] != '[':
                    temp += stack.pop()

                stack.pop()

                while stack and stack[-1].isdigit():
                    digit += stack.pop()

                for i in range(int(digit[::-1])):
                    stack.append(temp)
        while len(stack) > 0:
            result += stack.pop()

        return result[::-1]


print(Solution().decodeString("100[leetcode]"))
print(Solution().decodeString("3[a]2[bc]"))
print(Solution().decodeString("3[a2[c]]"))
print(Solution().decodeString("2[abc]3[cd]ef"))
print(Solution().decodeString("abc3[cd]xyz"))
