import math


def count_min_jumps(jumps):
    n = len(jumps)

    if n == 0:
        return 1

    if jumps[0] == 0:
        return -1

    dp = [math.inf for _ in range(n)]
    dp[0] = 0

    for i in range(n - 1):
        j = i + 1
        available = jumps[i]
        while j <= i + available and j < n:
            dp[j] = min(dp[j], dp[i] + 1)
            j += 1

    return dp[n - 1]


def main():
    print(count_min_jumps([2, 1, 1, 1, 4]))
    print(count_min_jumps([1, 1, 3, 6, 9, 3, 0, 1, 3]))


if __name__ == '__main__':
    main()
