from heapq import *


class Solution:
    def kthFactor_brute(self, n, k):
        for i in range(1, n // 2 + 1):
            if n % i == 0:
                k -= 1
            if k == 0:
                return i
        return n if k == 1 else -1

    def kthFactor(self, n, k):
        heap = []

        for i in range(1, int(n ** 0.5) + 1):
            if n % i == 0:
                heappush(heap, -i)
                if len(heap) > k:
                    heappop(heap)

                if n//i != i:
                    heappush(heap, - (n//i))
                    if len(heap) > k:
                        heappop(heap)

        return -heappop(heap) if len(heap) == k else -1


print(Solution().kthFactor(n=4, k=4))
print(Solution().kthFactor(n=24, k=6))
print(Solution().kthFactor(n=12, k=3))
print(Solution().kthFactor(n=7, k=2))

print(' ')

print(Solution().kthFactor_brute(n=4, k=4))
print(Solution().kthFactor_brute(n=24, k=6))
print(Solution().kthFactor_brute(n=12, k=3))
print(Solution().kthFactor_brute(n=7, k=2))
