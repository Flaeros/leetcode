# P[i+1] = A[0] + ... + A[i]
# for x in range(len(s))
# res[x] = P[x] + (N-x -(P[n] - P[x]))

class Solution(object):
    def minFlipsMonoIncr(self, s):
        n = len(s)
        p = [int(s[0])]

        for char in s:
            p.append(int(char) + p[-1])


        for i in range(3):
            for j in range(i, -1, -1):
                print(i)
                print(j)
                print("-")

        result = n
        for i in range(len(p)):
            result = min(result, p[i] + n - i - (p[-1] - p[i]))

        return result


print(Solution().minFlipsMonoIncr("11011"))
print(Solution().minFlipsMonoIncr("00011000"))
print(Solution().minFlipsMonoIncr("00110"))
