def search_triplets(arr):
    triplets = []
    arr.sort()

    for i, num in enumerate(arr):
        k = i + 1
        while k < len(arr) and arr[k] == arr[i]:
            k += 1

        find_triplets(arr, -arr[i], k, triplets)

    return triplets


def find_triplets(arr, total, left, triplets):
    right = len(arr) - 1

    while left < right:
        current_sum = arr[left] + arr[right]
        if current_sum == total:
            triplets.append([-total, arr[left], arr[right]])
            left += 1
            right -= 1

            while left < right and arr[right] == arr[right + 1]:
                right -= 1
            while left < right and arr[left] == arr[left - 1]:
                left += 1
        elif total > current_sum:
            left += 1
        else:
            right -= 1


print(search_triplets([-3, 0, 1, 2, -1, 1, -2]))
print(search_triplets([-5, 2, -1, -2, 3]))
