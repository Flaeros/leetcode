import math


def count_min_jumps(jumps):
    memo = [-1 for _ in range(len(jumps) + 1)]
    return count_min_jumps_rec(jumps, memo, 0)


def count_min_jumps_rec(jumps, memo, index):
    n = len(jumps)

    if index >= n:
        return math.inf

    if memo[index] != -1:
        return memo[index]

    if index == n - 1:
        return 0

    available = jumps[index]
    if available == 0:
        return math.inf

    pre = math.inf
    i = 1

    while i <= available and i < n:
        result = count_min_jumps_rec(jumps, memo, index + i)
        i = i + 1
        if result != math.inf:
            pre = min(pre, result + 1)

    memo[index] = pre

    return memo[index]


def main():
    print(count_min_jumps([2, 1, 1, 1, 4]))
    print(count_min_jumps([1, 1, 3, 6, 9, 3, 0, 1, 3]))


if __name__ == '__main__':
    main()
