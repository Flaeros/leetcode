package array;

import java.util.Arrays;

/**
 * Given two arrays of integers nums and index. Your task is to create target array under the following rules:
 *
 * Initially target array is empty.
 * From left to right read nums[i] and index[i], insert at index index[i] the value nums[i] in target array.
 * Repeat the previous step until there are no elements to read in nums and index.
 * Return the target array.
 *
 * It is guaranteed that the insertion operations will be valid.
 */
public class ArrayInOrder_1389 {

    /**
     * 1 <= nums.length, index.length <= 100
     * nums.length == index.length
     * 0 <= nums[i] <= 100
     * 0 <= index[i] <= i
     */
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new ArrayInOrder_1389().createTargetArray(new int[]{0,1,2,3,4}, new int[] {0,1,2,2,1})));
        System.out.println(Arrays.toString(new ArrayInOrder_1389().createTargetArray(new int[]{1,2,3,4,0}, new int[] {0,1,2,3,0})));
    }

    public int[] createTargetArray(int[] nums, int[] index) {
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            for (int j = result.length - 1; j >= index[i] + 1; j--) {
                result[j] = result[j-1];
            }
            result[index[i]] = nums[i];
        }
        return result;
    }
}
