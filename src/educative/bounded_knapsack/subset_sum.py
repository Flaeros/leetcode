def can_partition(num, sum):
    return can_partition_rec(num, sum, 0)


def can_partition_rec(num, sum, index):
    if sum == 0:
        return True

    if sum < 0:
        return False

    if len(num) <= index:
        return False

    can = can_partition_rec(num, sum - num[index], index + 1)
    if can:
        return True

    return can_partition_rec(num, sum, index + 1)


def main():
    print(can_partition([1, 2, 3, 7], 6))
    print(can_partition([1, 2, 7, 1, 5], 10))
    print(can_partition([1, 3, 4, 8], 6))


if __name__ == '__main__':
    main()
