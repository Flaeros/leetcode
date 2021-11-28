def find_target_subsets(num, s):
    return find_target_subsets_rec(num, s, 0)


def find_target_subsets_rec(num, s, index):
    if index >= len(num):
        if s == 0:
            return 1
        else:
            return 0

    if len(num) == 0 and s == 0:
        return 1

    plus = find_target_subsets_rec(num, s - num[index], index + 1)
    minus = find_target_subsets_rec(num, s + num[index], index + 1)

    return plus + minus


def main():
    print(find_target_subsets([1, 1, 2, 3], 1))
    print(find_target_subsets([1, 2, 7, 1], 9))


if __name__ == '__main__':
    main()
