def find_SI(m, n, p):
    m_len, n_len, p_pen = len(m), len(n), len(p)
    dp = [[False for _ in range(n_len + 1)] for _ in range(m_len + 1)]

    if m_len + n_len != p_pen:
        return False

    for m_index in range(m_len + 1):
        for n_index in range(n_len + 1):
            if m_index == 0 and n_index == 0:
                dp[m_index][n_index] = True
            elif m_index == 0 and n[n_index - 1] == p[n_index - 1]:
                dp[0][n_index] = dp[0][n_index - 1]
            elif n_index == 0 and m[m_index - 1] == p[m_index - 1]:
                dp[m_index][0] = dp[m_index - 1][0]
            else:
                if m_index > 0 and m[m_index - 1] == p[m_index + n_index - 1]:
                    dp[m_index][n_index] = dp[m_index - 1][n_index]
                elif n_index > 0 and n[n_index - 1] == p[m_index + n_index - 1]:
                    dp[m_index][n_index] = dp[m_index][n_index - 1]

    return dp[m_len][n_len]


def main():
    print(find_SI("abd", "cef", "abcdef"))
    print(find_SI("abd", "cef", "adcbef"))
    print(find_SI("abc", "def", "abdccf"))
    print(find_SI("abcdef", "mnop", "mnaobcdepf"))


main()
