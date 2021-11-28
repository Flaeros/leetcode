def find_SPM_count(str, pat):
    memo = [[-1 for _ in range(len(pat))] for _ in range(len(str))]
    return find_SPM_count_rec(str, pat, memo, 0, 0)


def find_SPM_count_rec(str, pat, memo, i, j):
    if j == len(pat):
        return 1

    if i == len(str):
        return 0

    if memo[i][j] != -1:
        return memo[i][j]

    inclusive = 0
    if str[i] == pat[j]:
        inclusive = find_SPM_count_rec(str, pat, memo, i + 1, j + 1)

    exclusive = find_SPM_count_rec(str, pat, memo, i + 1, j)

    memo[i][j] = inclusive + exclusive

    return memo[i][j]


def main():
    print(find_SPM_count("baxmx", "ax"))
    print(find_SPM_count("tomorrow", "tor"))


if __name__ == '__main__':
    main()
