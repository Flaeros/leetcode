def find_LPS_length(st):
    n = len(st)

    dp = [[False for _ in range(n)] for _ in range(n)]

    max_length = 1

    for i in range(n):
        dp[i][i] = True

    for start in range(n, -1, -1):
        for end in range(start + 1, n):
            if st[start] == st[end]:
                if end - start == 1 or dp[start + 1][end - 1]:
                    dp[start][end] = True
                    max_length = max(max_length, end - start + 1)

    return max_length


def main():
    print(find_LPS_length("abdbca"))
    print(find_LPS_length("cddpd"))
    print(find_LPS_length("pqr"))


if __name__ == '__main__':
    main()
