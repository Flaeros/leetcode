def find_min_fee(fee):
    memo = [-1 for _ in range(len(fee))]
    return find_min_fee_rec(fee, memo, 0)


def find_min_fee_rec(fee, memo, index):
    n = len(fee)
    if index >= n:
        return 0

    if memo[index] == -1:
        res1 = find_min_fee_rec(fee, memo, index + 1)
        res2 = find_min_fee_rec(fee, memo, index + 2)
        res3 = find_min_fee_rec(fee, memo, index + 3)

        res = min(res1, res2, res3)

        memo[index] = res + fee[index]

    return memo[index]


def main():
    print(find_min_fee([1, 2, 5, 2, 1, 2]))
    print(find_min_fee([2, 3, 4, 5]))


if __name__ == '__main__':
    main()
