class Solution(object):
    def isRobotBounded(self, instructions):
        x, y = 0, 0
        idx = 0
        directions = [[0, 1], [1, 0], [0, -1], [-1, 0]]

        for i in instructions:
            if i == 'L':
                idx = (idx + 3) % 4
            elif i == 'R':
                idx = (idx + 1) % 4
            else:
                x += directions[idx][0]
                y += directions[idx][1]

        return True if (x == 0 and y == 0) or idx != 0 else False


print(Solution().isRobotBounded("GGLLGG"))
print(Solution().isRobotBounded("GG"))
print(Solution().isRobotBounded("GL"))
