def can_partition(num):
    return can_partition_rec(num, 0, 0, 0)


def can_partition_rec(num, index, left, right):
    if index >= len(num):
        return abs(left-right)

    left_test = can_partition_rec(num, index + 1, left + num[index], right)
    right_test = can_partition_rec(num, index + 1, left, right + num[index])

    return min(left_test, right_test)


def main():
    print("Can partition: " + str(can_partition([1, 2, 3, 9])))


# print("Can partition: " + str(can_partition([1, 2, 7, 1, 5])))
# print("Can partition: " + str(can_partition([1, 3, 100, 4])))


if __name__ == '__main__':
    main()
