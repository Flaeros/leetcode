def find_MPP_cuts(st):
    n = len(st)

    is_palindrome = [[False for _ in range(n)] for _ in range(n)]

    for i in range(n):
        is_palindrome[i][i] = True

    for start in range(n - 1, -1, -1):
        for end in range(start + 1, n):
            if st[start] == st[end]:
                if end - start == 1 or is_palindrome[start + 1][end - 1]:
                    is_palindrome[start][end] = True

    cuts = [0 for _ in range(n)]

    for start in range(n - 1, -1, -1):
        min_cuts = n
        for end in range(n - 1, start - 1, -1):
            if is_palindrome[start][end]:
                min_cuts = 0 if end == n - 1 else min(min_cuts, 1 + cuts[end + 1])

        cuts[start] = min_cuts

    return cuts[0]


def main():
    print(find_MPP_cuts("abdbca"))
    print(find_MPP_cuts("cdpdd"))
    print(find_MPP_cuts("pqr"))
    print(find_MPP_cuts("pp"))
    print(find_MPP_cuts("madam"))


if __name__ == '__main__':
    main()
