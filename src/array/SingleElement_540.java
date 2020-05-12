package array;

/**
 * You are given a sorted array consisting of only integers where every element appears exactly twice,
 * except for one element which appears exactly once. Find this single element that appears only once.
 */
public class SingleElement_540 {
    public static void main(String[] args) {
        System.out.println(new SingleElement_540().singleNonDuplicate(new int[]{1, 1, 2, 3, 3, 4, 4, 8, 8}));
        System.out.println(new SingleElement_540().singleNonDuplicate(new int[]{3, 3, 7, 7, 10, 11, 11}));
    }

    public int singleNonDuplicate(int[] nums) {
        if(nums.length == 1)
            return nums[0];

        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (mid == 0 && nums[mid] != nums[mid + 1]) {
                return nums[mid];
            }
            if (mid == nums.length - 1 && nums[mid] != nums[mid - 1]) {
                return nums[mid];
            }
            if (nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1]) {
                return nums[mid];
            }

            if (nums[mid] == nums[mid + 1]) {
                if (mid % 2 == 0) {
                    low = mid + 1;
                } else {
                    high = high -1;
                }
            } else {
                if (mid % 2 == 0) {
                    high = high -1;
                } else {
                    low = mid + 1;
                }
            }
        }
        return -1;
    }

}
