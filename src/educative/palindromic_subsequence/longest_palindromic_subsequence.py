def find_LPS_length(st):
    n = len(st)

    dp = [[0 for _ in range(n)] for _ in range(n)]

    for i in range(n):
        dp[i][i] = 1

    for start in range(n - 1, -1, -1):
        for end in range(start + 1, n):
            if st[start] == st[end]:
                dp[start][end] = 2 + dp[start + 1][end - 1]
            else:
                dp[start][end] = max(dp[start + 1][end], dp[start][end - 1])

    return dp[0][n-1]


def main():
    print(find_LPS_length("abdbca"))
    print(find_LPS_length("cddpd"))
    print(find_LPS_length("pqr"))


if __name__ == '__main__':
    main()