def find_SI(m, n, p):
    return find_SI_rec({}, m, n, p, 0, 0, 0)


def find_SI_rec(memo, m, n, p, m_index, n_index, p_index):
    m_len, n_len, p_len = len(m), len(n), len(p)

    key = str(m_index) + '-' + str(n_index) + '-' + str(p_index)

    if key in memo:
        return memo.get(key)

    if m_index == m_len and n_index == n_len and p_index == p_len:
        return True
    if p_index == p_len:
        return False

    b1, b2 = False, False
    if m_index < m_len and m[m_index] == p[p_index]:
        b1 = find_SI_rec(memo, m, n, p, m_index + 1, n_index, p_index + 1)
    if n_index < n_len and n[n_index] == p[p_index]:
        b2 = find_SI_rec(memo, m, n, p, m_index, n_index + 1, p_index + 1)

    memo[key] = b1 or b2
    return memo.get(key)


def main():
    print(find_SI("abd", "cef", "abcdef"))
    print(find_SI("abd", "cef", "adcbef"))
    print(find_SI("abc", "def", "abdccf"))
    print(find_SI("abcdef", "mnop", "mnaobcdepf"))


main()
