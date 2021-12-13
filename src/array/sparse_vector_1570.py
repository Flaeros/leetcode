class SparseVector:
    def __init__(self, nums):
        self.coords = {}
        for i, num in enumerate(nums):
            if num != 0:
                self.coords[i] = num

    # Return the dotProduct of two sparse vectors
    def dotProduct(self, vec):
        result = 0

        for key, num in self.coords.items():
            if key in vec.coords:
                result += num * vec.coords[key]

        return result


# Your SparseVector object will be instantiated and called as such:
nums1 = [1, 0, 0, 2, 3]
nums2 = [0, 3, 0, 4, 0]
v1 = SparseVector(nums1)
v2 = SparseVector(nums2)
ans = v1.dotProduct(v2)
print(ans)
