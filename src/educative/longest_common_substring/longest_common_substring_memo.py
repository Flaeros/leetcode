def find_LCS_length(s1, s2):
    n1 = len(s1)
    n2 = len(s2)
    n3 = min(n1, n2)

    memo = [[[-1 for _ in range(n3)] for _ in range(n2)] for _ in range(n1)]
    return find_LCS_length_rec(memo, s1, s2, 0, 0, 0)


def find_LCS_length_rec(memo, s1, s2, i, j, length):
    if i >= len(s1) or j >= len(s2):
        return length

    if memo[i][j][length] != -1:
        return memo[i][j][length]

    c1 = length
    if s1[i] == s2[j]:
        c1 = find_LCS_length_rec(memo, s1, s2, i + 1, j + 1, length + 1)

    first = find_LCS_length_rec(memo, s1, s2, i + 1, j, 0)
    second = find_LCS_length_rec(memo, s1, s2, i, j + 1, 0)

    memo[i][j][length] = max(c1, max(first, second))

    return memo[i][j][length]


def main():
    print(find_LCS_length("abdca", "cbda"))
    print(find_LCS_length("passport", "ppsspt"))


if __name__ == '__main__':
    main()
