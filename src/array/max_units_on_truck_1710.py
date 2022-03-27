class Solution:
    def maximumUnits(self, boxTypes, truckSize):
        boxTypes.sort(key=lambda x: -x[1])
        itemCount = 0
        for boxType in boxTypes:
            boxCount = min(truckSize, boxType[0])
            itemCount += boxCount * boxType[1]
            truckSize -= boxCount

        return itemCount


print(Solution().maximumUnits(boxTypes=[[1, 3], [2, 2], [3, 1]], truckSize=4))
print(Solution().maximumUnits(boxTypes=[[5, 10], [2, 5], [4, 7], [3, 9]], truckSize=10))
