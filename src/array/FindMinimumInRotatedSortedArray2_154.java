package array;

public class FindMinimumInRotatedSortedArray2_154 {

    public static void main(String[] args) {
        System.out.println(new FindMinimumInRotatedSortedArray2_154().findMin(new int[]{2, 2, 2, 0, 1}));
        System.out.println(new FindMinimumInRotatedSortedArray2_154().findMin(new int[]{1, 3, 5}));
    }

    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        int mid;

        while (low < high) {
            mid = low + (high - low) / 2;

            if (nums[mid] < nums[high]) {
                high = mid;
            } else if (nums[mid] > nums[high]) {
                low = mid + 1;
            } else {
                high--;
            }
        }

        return nums[low];
    }
}
