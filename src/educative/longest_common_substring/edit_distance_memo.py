def find_min_operations(s1, s2):
    memo = [[-1 for _ in range(len(s2)+1)] for _ in range(len(s1)+1)]
    return find_min_operations_rec(s1, s2, memo, 0, 0)


def find_min_operations_rec(s1, s2, memo, i1, i2):
    n1 = len(s1)
    n2 = len(s2)

    if memo[i1][i2] != -1:
        return memo[i1][i2]

    if i2 == n2:
        return n1 - i1

    if i1 == n1:
        return n2 - i2

    if s1[i1] == s2[i2]:
        memo[i1][i2] = find_min_operations_rec(s1, s2, memo, i1 + 1, i2 + 1)
    else:
        c1 = find_min_operations_rec(s1, s2, memo, i1 + 1, i2)
        c2 = find_min_operations_rec(s1, s2, memo, i1, i2 + 1)
        c3 = find_min_operations_rec(s1, s2, memo, i1 + 1, i2 + 1)
        memo[i1][i2] = 1 + min(c1, c2, c3)

    return memo[i1][i2]


def main():
    print(find_min_operations("bat", "but"))
    print(find_min_operations("abdca", "cbda"))
    print(find_min_operations("passpot", "ppsspqrt"))


main()
