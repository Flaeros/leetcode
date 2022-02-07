def can_attend_all_appointments(intervals):
    intervals = sorted(intervals, key=lambda x: x[0])

    start, end = 0, 1
    for i in range(1, len(intervals)):
        prev_start, prev_end = intervals[i - 1][start], intervals[i - 1][end]
        next_start, next_end = intervals[i][start], intervals[i][end]

        if next_start < prev_end:
            return False

    return True


def main():
    print("Can attend all appointments: " + str(can_attend_all_appointments([[1, 4], [2, 5], [7, 9]])))
    print("Can attend all appointments: " + str(can_attend_all_appointments([[6, 7], [2, 4], [8, 12]])))
    print("Can attend all appointments: " + str(can_attend_all_appointments([[4, 5], [2, 3], [3, 6]])))


main()
