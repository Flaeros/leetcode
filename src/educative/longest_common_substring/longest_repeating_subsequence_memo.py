def find_LRS_length(str):
    n = len(str)
    memo = [[-1 for _ in range(n)] for _ in range(n)]
    return find_LRS_length_rec(str, memo, 0, 0)


def find_LRS_length_rec(str, memo, i1, i2):
    n = len(str)
    if i1 == n or i2 == n:
        return 0

    if memo [i1][i2] != -1:
        return memo [i1][i2]

    if str[i1] == str[i2] and i1 != i2:
        return 1 + find_LRS_length_rec(str, memo, i1 + 1, i2 + 1)

    left = find_LRS_length_rec(str, memo, i1 + 1, i2)
    right = find_LRS_length_rec(str, memo, i1, i2 + 1)

    memo [i1][i2] = max(left, right)
    return memo [i1][i2]


def main():
    print(find_LRS_length("tomorrow"))
    print(find_LRS_length("aabdbcec"))
    print(find_LRS_length("fmff"))


if __name__ == '__main__':
    main()
