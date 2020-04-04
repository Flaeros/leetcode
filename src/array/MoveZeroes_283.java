package array;

import java.util.Arrays;

/**
 * Given an array nums, write a function to move all 0's
 * to the end of it while maintaining the relative order of the non-zero elements.
 */
public class MoveZeroes_283 {

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        new MoveZeroes_283().moveZeroes(nums);
        System.out.println(Arrays.toString(nums));

        nums = new int[]{1, 0};
        new MoveZeroes_283().moveZeroes(nums);
        System.out.println(Arrays.toString(nums));

        nums = new int[]{2, 1};
        new MoveZeroes_283().moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void moveZeroes(int[] nums) {
        int pos = 0;
        for(int i = 0;i < nums.length;i++) {
            if(nums[i] != 0) {
                if(i != pos) {
                    nums[pos] = nums[i];
                    nums[i] = 0;
                }
                pos++;
            }
        }
    }
}
