def search_ceiling_of_a_number(arr, key):
    if len(arr) == 0 or arr[-1] < key:
        return -1

    start, end = 0, len(arr) - 1
    while start <= end:
        middle = start + (end - start) // 2
        if arr[middle] < key:
            start = middle + 1
        elif key < arr[middle]:
            end = middle - 1
        else:
            return middle

    return start


def main():
    print(search_ceiling_of_a_number([1, 3, 8, 10, 15], 12))
    print(search_ceiling_of_a_number([4, 6, 10], 6))
    print(search_ceiling_of_a_number([4, 6, 10], 17))
    print(search_ceiling_of_a_number([4, 6, 10], -1))


main()
