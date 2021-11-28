def find_max_steal(wealth):
    memo = [-1 for _ in range(len(wealth))]
    return find_max_steal_rec(wealth, memo, 0)


def find_max_steal_rec(wealth, memo, index):
    if index >= len(wealth):
        return 0

    if memo[index] == -1:
        inclusive = wealth[index] + find_max_steal_rec(wealth, memo, index + 2)
        exclusive = find_max_steal_rec(wealth, memo, index + 1)
        memo[index] = max(inclusive, exclusive)

    return memo[index]


def main():
    print(find_max_steal([2, 5, 1, 3, 6, 2, 4]))
    print(find_max_steal([2, 10, 14, 8, 1]))


if __name__ == '__main__':
    main()
