package array;

import java.util.Arrays;

public class RotateArray_189 {

    public static void main(String[] args) {
        int[] nums;

        nums = new int[]{1, 2, 3, 4};
        new RotateArray_189().rotate(nums, 2);
        System.out.println(Arrays.toString(nums));

        nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        new RotateArray_189().rotate(nums, 3);
        System.out.println(Arrays.toString(nums));

        nums = new int[]{1, 2, 3};
        new RotateArray_189().rotate(nums, 1);
        System.out.println(Arrays.toString(nums));

        nums = new int[]{-1, -100, 3, 99};
        new RotateArray_189().rotate(nums, 2);
        System.out.println(Arrays.toString(nums));

        nums = new int[]{-1};
        new RotateArray_189().rotate(nums, 2);
        System.out.println(Arrays.toString(nums));

        nums = new int[]{-1, -10};
        new RotateArray_189().rotate(nums, 1);
        System.out.println(Arrays.toString(nums));

        nums = new int[]{1, 2};
        new RotateArray_189().rotate(nums, 3);
        System.out.println(Arrays.toString(nums));
    }

    public void rotate(int[] nums, int k) {
        if (nums.length == 1)
            return;
        k = k % nums.length;

        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[end];
            nums[end] = nums[start];
            nums[start] = temp;
            start++;
            end--;
        }
    }

    public void rotate3(int[] nums, int k) {
        if (nums.length == 1)
            return;
        k = k % nums.length;

        for (int i = 0; i < k; i++) {
            int prev = nums[nums.length - 1];
            for (int j = 0; j < nums.length; j++) {
                int temp = nums[j];
                nums[j] = prev;
                prev = temp;
            }
        }
    }

    public void rotate2(int[] nums, int k) {
        if (nums.length == 1)
            return;
        int[] res = new int[nums.length];

        k = k % nums.length;

        int j = 0;
        for (int i = nums.length - k; i < nums.length; i++) {
            res[j++] = nums[i];
        }
        for (int i = 0; i < nums.length - k; i++) {
            res[i + k] = nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = res[i];
        }
    }
}
