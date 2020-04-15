package array;

import java.util.Arrays;

/**
 * Given an array nums of n integers where n > 1,
 * return an array output such that output[i] is equal to
 * the product of all the elements of nums except nums[i].
 */
public class ProductExceptSelf_238 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new ProductExceptSelf_238().productExceptSelf(new int[]{1, 2, 3, 4})));

    }

    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];

        int[] lefts = new int[nums.length];
        int[] rights = new int[nums.length];

        lefts[0] = 1;
        rights[nums.length - 1] = 1;

        for (int i = 0; i < nums.length - 1; i++) {
            lefts[i + 1] = nums[i] * lefts[i];
        }

        for (int i = nums.length - 1; i > 0; i--) {
            rights[i - 1] = rights[i] * nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            result[i] = lefts[i] * rights[i];
        }

        return result;
    }
}
