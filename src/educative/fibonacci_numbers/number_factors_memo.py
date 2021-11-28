def count_ways(n):
    memo = [-1 for _ in range(n + 1)]
    return count_ways_rec(n, memo)


def count_ways_rec(n, memo):
    if n == 0:
        return 1
    if n == 1:
        return 1
    if n == 2:
        return 1
    if n == 3:
        return 2

    if memo[n] == -1:
        memo[n] = count_ways_rec(n - 1, memo) + count_ways_rec(n - 3, memo) + count_ways_rec(n - 4, memo)

    return memo[n]


def main():
    print(count_ways(4))
    print(count_ways(5))
    print(count_ways(6))


if __name__ == '__main__':
    main()
