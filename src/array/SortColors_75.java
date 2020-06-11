package array;

import java.util.Arrays;

public class SortColors_75 {

    public static void main(String[] args) {
        int[] nums = {2, 0, 2, 1, 1, 0};
        new SortColors_75().sortColors(nums);
        System.out.println(Arrays.toString(nums));

        nums = new int[]{2, 0, 1};
        new SortColors_75().sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void sortColors(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        for (int i = 0; i <= high; ) {
            if (nums[i] == 0) {
                int temp = nums[i];
                nums[i] = nums[low];
                nums[low] = temp;
                low++;
                i++;
            } else if (nums[i] == 2) {
                int temp = nums[i];
                nums[i] = nums[high];
                nums[high] = temp;
                high--;
            } else {
                i++;
            }
        }
    }

    public void sortColorsEz(int[] nums) {
        int c0 = 0;
        int c1 = 0;
        for (int num : nums) {
            if (num == 0)
                c0++;
            if (num == 1)
                c1++;
        }


        for (int i = 0; i < nums.length; i++) {
            if (i < c0) {
                nums[i] = 0;
            } else if (i >= c0 && i < c0 + c1) {
                nums[i] = 1;
            } else {
                nums[i] = 2;
            }
        }
    }
}
