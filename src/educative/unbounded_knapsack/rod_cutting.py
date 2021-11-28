def solve_rod_cutting(lengths, prices, n):
    return solve_rod_cutting_rec(lengths, prices, n, 0)


def solve_rod_cutting_rec(lengths, prices, n, index):

    if index >= len(lengths):
        return 0

    inclusive = 0
    if lengths[index] <= n:
        inclusive = prices[index] + solve_rod_cutting_rec(lengths, prices, n - lengths[index], index)

    exclusive = solve_rod_cutting_rec(lengths, prices, n, index + 1)

    return max(exclusive, inclusive)


def main():
    print(solve_rod_cutting([1, 2, 3, 4, 5], [2, 6, 7, 10, 13], 5))


if __name__ == '__main__':
    main()
