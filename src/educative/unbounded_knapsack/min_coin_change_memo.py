import math


def count_change(denominations, total):
    dp = [[-1 for x in range(total + 1)] for y in range(len(denominations))]
    result = count_change_rec(denominations, total, dp, 0)
    return -1 if result == math.inf else result


def count_change_rec(denominations, total, dp, index):
    if total == 0:
        return 0

    n = len(denominations)

    if n == 0 or n <= index:
        return math.inf

    if dp[index][total] != -1:
        return dp[index][total]

    inclusive = math.inf
    if denominations[index] <= total:
        res = count_change_rec(denominations, total - denominations[index], dp, index)
        if res != math.inf:
            inclusive = res + 1

    exclusive = count_change_rec(denominations, total, dp, index + 1)

    dp[index][total] = min(inclusive, exclusive)

    return dp[index][total]


def main():
    print(count_change([1, 2, 3], 5))
    print(count_change([1, 2, 3], 11))
    print(count_change([1, 2, 3], 7))
    print(count_change([3, 5], 7))


if __name__ == '__main__':
    main()
