def find_LCS_length(s1, s2):
    memo = [[-1 for _ in range(len(s2))] for _ in range(len(s1))]
    return find_LCS_length_rec(memo, s1, s2, 0, 0)


def find_LCS_length_rec(memo, s1, s2, i, j):
    if i >= len(s1) or j >= len(s2):
        return 0

    if memo[i][j] != -1:
        return memo[i][j]

    if s1[i] == s2[j]:
        return 1 + find_LCS_length_rec(memo, s1, s2, i + 1, j + 1)

    first = find_LCS_length_rec(memo, s1, s2, i + 1, j)
    second = find_LCS_length_rec(memo, s1, s2, i, j + 1)

    memo[i][j] = max(first, second)

    return memo[i][j]


def main():
    print(find_LCS_length("abdca", "cbda"))
    print(find_LCS_length("passport", "ppsspt"))


if __name__ == '__main__':
    main()
