# Definition for a binary tree node.
class Node(object):
    def __init__(self, val=" ", left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


# read string from left
# save operators and operands in two stacks
# calculate nodes on fly when possible:
# if +- and prev operator is +-*/, we can calculate prev expr
# if */ and prev operator is */ we can calculate prev expr
# if (, save it to operators
# if ), calculate prev expr until (

class Solution:
    def expTree(self, s: str) -> 'Node':
        ops = []
        nums = []

        def calculate():

            op = ops.pop()
            r = nums.pop()
            l = nums.pop()

            nums.append(Node(val=op, left=l, right=r))

        for d in s:
            if d.isdigit():
                nums.append(Node(val=d))
            elif d in ('+', '-'):
                while ops and ops[-1] in ('+', '-', '*', '/'):
                    calculate()
                ops.append(d)
            elif d in ('*', '/'):
                while ops and ops[-1] in ('*', '/'):
                    calculate()
                ops.append(d)
            elif d == '(':
                ops.append(d)
            elif d == ')':
                while ops[-1] != '(':
                    calculate()
                ops.pop()

        while ops:
            calculate()

        return nums[-1]


print(Solution().expTree("3*4-2*5"))
print(Solution().expTree("2-3/(5*2)+1"))
print(Solution().expTree("1+2+3+4+5"))
