def find_SPM_count(str, pat):
    n_str = len(str)
    n_pat = len(pat)

    if n_pat == 0:
        return 1

    if n_str == 0:
        return 0

    dp = [[0 for _ in range(n_pat + 1)] for _ in range(n_str + 1)]

    for i in range(n_str):
        dp[i][0] = 1

    for i in range(1, n_str + 1):
        for j in range(1, n_pat + 1):
            if str[i - 1] == pat[j - 1]:
                dp[i][j] = dp[i - 1][j - 1]
            dp[i][j] += dp[i - 1][j]

    return dp[n_str][n_pat]


def main():
    print(find_SPM_count("baxmx", "ax"))
    print(find_SPM_count("tomorrow", "tor"))


if __name__ == '__main__':
    main()
