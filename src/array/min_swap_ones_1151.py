class Solution:
    def minSwaps(self, data):
        ones = 0
        for char in data:
            if char == 1:
                ones += 1

        w_start = 0
        n = len(data)
        current = 0

        maximum = 0

        for w_end in range(n):
            if data[w_end] == 1:
                current += 1

            if w_end - w_start == ones:
                if data[w_start] == 1:
                    current -= 1
                w_start += 1

            maximum = max(maximum, current)

        return ones - maximum


print(Solution().minSwaps([1, 0, 1, 0, 1]))  # 1
print(Solution().minSwaps([0, 0, 0, 1, 0]))  # 0
print(Solution().minSwaps([1, 0, 1, 0, 1, 0, 0, 1, 1, 0, 1]))  # 3
