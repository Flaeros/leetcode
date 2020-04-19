package array;

public class SearchInRotatedArray_33 {
    public static void main(String[] args) {
        System.out.println(new SearchInRotatedArray_33().search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
        System.out.println(new SearchInRotatedArray_33().search(new int[]{2, 3, 4, 5, 6, 7, 8, 9, 0, 1}, 1));
        System.out.println(new SearchInRotatedArray_33().search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3));
    }

    public int search(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            int k = (i + j) / 2;
            if (nums[k] > nums[j])
                i = k + 1;
            else
                j = k;
        }

        int shift = j;
        i = 0;
        j = nums.length - 1;

        while (i <= j) {
            int k = (i + j) / 2;
            int mid = (k + shift) % nums.length;
            if (nums[mid] == target)
                return mid;
            if (nums[mid] > target) {
                j = k - 1;
            } else {
                i = k + 1;
            }
        }

        return -1;
    }

    public int search1(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;
        int k = i;
        while (i < j) {
            if (nums[k] == target)
                return k;
            if (nums[k] < target) {
                if (nums[i] < nums[k]) {
                    i = k;
                    k = (i + j) / 2;
                } else {
                    j = k;
                    k = (i + j) / 2;
                }
            } else {
                if (nums[j] > nums[k]) {
                    j = k;
                    k = (i + j) / 2;
                } else {
                    i = k;
                    k = (i + j) / 2;
                }
            }

        }

        return -1;
    }
}
