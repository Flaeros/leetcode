from heapq import *


class MedianOfAStream:
    left = []
    right = []

    def insert_num(self, num):

        if not self.left or num <= -self.left[0]:
            heappush(self.left, -num)
        else:
            heappush(self.right, num)

        if len(self.left) > len(self.right) + 1:
            heappush(self.right, -heappop(self.left))
        elif len(self.left) < len(self.right):
            heappush(self.left, -heappop(self.right))

    def find_median(self):
        if len(self.left) == 0 and len(self.right) == 0:
            return 0.0

        if len(self.left) == len(self.right):
            return (-self.left[0] + self.right[0]) / 2
        return -self.left[0]


def main():
    medianOfAStream = MedianOfAStream()
    medianOfAStream.insert_num(3)
    medianOfAStream.insert_num(1)
    print("The median is: " + str(medianOfAStream.find_median()))
    medianOfAStream.insert_num(5)
    print("The median is: " + str(medianOfAStream.find_median()))
    medianOfAStream.insert_num(4)
    print("The median is: " + str(medianOfAStream.find_median()))


main()
