def count_PS(st):
    n = len(st)

    dp = [[False for _ in range(n)] for _ in range(n)]

    count = 0

    for i in range(n):
        dp[i][i] = True

    for start in range(n, -1, -1):
        for end in range(start + 1, n):
            if st[start] == st[end]:
                if end - start == 1 or dp[start + 1][end - 1]:
                    dp[start][end] = True
                    count += 1

    return count + n


def main():
    print(count_PS("abdbca"))
    print(count_PS("cddpd"))
    print(count_PS("pqr"))


if __name__ == '__main__':
    main()
