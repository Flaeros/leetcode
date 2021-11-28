def find_target_subsets(num, s):
    if any(i < 1 for i in num):
        return -1

    total = sum(num)

    if total < s or (total + s) % 2 == 1:
        return -1

    return count_subsets(num, int((total + s) / 2))


def count_subsets(num, s):
    n = len(num)
    dp = [[0 for x in range(s + 1)] for y in range(n)]

    for i in range(n):
        dp[i][0] = 1

    for j in range(1, s + 1):
        dp[0][j] = 1 if j == s else 0

    for i in range(1, n):
        for j in range(1, s + 1):
            dp[i][j] = dp[i - 1][j]
            if num[i] <= s:
                dp[i][j] += dp[i - 1][j - num[i]]

    return dp[n - 1][s]


def main():
    print(find_target_subsets([1, 1, 2, 3], 1))
    print(find_target_subsets([1, 2, 7, 1], 9))


if __name__ == '__main__':
    main()
