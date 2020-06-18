package math;

import java.util.Arrays;

public class PlusOne_66 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new PlusOne_66().plusOne(new int[]{9, 8, 9})));
        System.out.println(Arrays.toString(new PlusOne_66().plusOne(new int[]{9, 9})));
        System.out.println(Arrays.toString(new PlusOne_66().plusOne(new int[]{0})));
        System.out.println(Arrays.toString(new PlusOne_66().plusOne(new int[]{1, 2, 3})));
        System.out.println(Arrays.toString(new PlusOne_66().plusOne(new int[]{4, 3, 2, 1})));
        System.out.println(Arrays.toString(new PlusOne_66().plusOne(new int[]{8, 9})));
    }

    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }

        int[] res = new int[digits.length + 1];
        res[0] = 1;
        return res;
    }
}