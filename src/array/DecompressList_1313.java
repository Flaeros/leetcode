package array;

import java.util.Arrays;

/**
 * We are given a list nums of integers representing a list compressed with run-length encoding.
 *
 * Consider each adjacent pair of elements [freq, val] = [nums[2*i], nums[2*i+1]] (with i >= 0).
 * For each such pair, there are freq elements with value val concatenated in a sublist. Concatenate all the sublists from left to right to generate the decompressed list.
 *
 * Return the decompressed list.
 */
public class DecompressList_1313 {

    /**
     * 2 <= nums.length <= 100
     * nums.length % 2 == 0
     * 1 <= nums[i] <= 100
     */
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new DecompressList_1313().decompressRLElist(new int[]{1,2,3,4})));
        System.out.println(Arrays.toString(new DecompressList_1313().decompressRLElist(new int[]{1,1,2,3})));
    }

    public int[] decompressRLElist(int[] nums) {
        int size = 0;
        for (int i = 0; i < nums.length; i = i + 2) {
            size += nums[i];
        }
        int[] result = new int[size];

        int k = 0;
        for (int i = 0; i < nums.length; i = i+2) {
            int freq = nums[i];
            int val = nums[i + 1];
            for (int j = 0; j < freq; j++) {
                result[k++] = val;
            }
        }

        return result;
    }
}
