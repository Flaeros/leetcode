# basic
# two cycles: i: 0, N; j: i, N
# second cycle will represent contiguous subarray
# in second cycle, calculate minimum, sum up to result


# stack
# iterate N
# keep in the stack elements not more than current
# can reuse previous solutions

class Solution:
    def sumSubarrayMinsIterate(self, arr):
        result = 0
        n = len(arr)
        for i in range(n):
            minimum = 30000
            for j in range(i, n):
                minimum = min(minimum, arr[j])
                result += minimum

        return result % (10 ** 9 + 7)

    def sumSubarrayMins(self, arr):
        arr = [0] + arr
        result = [0] * len(arr)
        stack = [0]

        for i in range(len(arr)):
            while arr[stack[-1]] > arr[i]:
                stack.pop()
            j = stack[-1]
            result[i] = result[j] + (i - j) * arr[i]
            stack.append(i)

        return sum(result) % (10 ** 9 + 7)


print(Solution().sumSubarrayMins([3, 1, 2, 4]))
print(Solution().sumSubarrayMins([11, 81, 94, 43, 3]))

print(Solution().sumSubarrayMinsIterate([3, 1, 2, 4]))
print(Solution().sumSubarrayMinsIterate([11, 81, 94, 43, 3]))
