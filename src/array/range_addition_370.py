# N - length, K - updates size

# bruteforce, apply all operations - K*N
# delta, calculate delta for each element - K*N
# merge ranges? heap?
# the math problem...

class Solution:
    def getModifiedArray(self, length, updates):
        result = [0] * length
        for start, end, val in updates:
            result[start] += val

            if end + 1 < length:
                result[end + 1] -= val

        for i in range(1, length):
            result[i] += result[i - 1]

        return result

    def getModifiedArrayNaive(self, length, updates):
        result = [0] * length

        for start, end, val in updates:
            for i in range(start, end + 1):
                result[i] += val

        return result


print(Solution().getModifiedArray(length=5, updates=[[1, 3, 2], [2, 4, 3], [0, 2, -2]]))
print(Solution().getModifiedArray(length=10, updates=[[2, 4, 6], [5, 6, 8], [1, 9, -4]]))

print(Solution().getModifiedArrayNaive(length=5, updates=[[1, 3, 2], [2, 4, 3], [0, 2, -2]]))
print(Solution().getModifiedArrayNaive(length=10, updates=[[2, 4, 6], [5, 6, 8], [1, 9, -4]]))
