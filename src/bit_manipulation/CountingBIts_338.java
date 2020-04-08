package bit_manipulation;

import java.util.Arrays;

/**
 * Given a non negative integer number num.
 * For every numbers i in the range 0 ≤ i ≤ num
 * calculate the number of 1's in their binary representation and return them as an array.
 */
public class CountingBIts_338 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new CountingBIts_338().countBits(2)));
        System.out.println(Arrays.toString(new CountingBIts_338().countBits(5)));
    }

    public int[] countBits(int num) {
        int[] f = new int[num + 1];
        for (int i = 1; i <= num; i++) f[i] = f[i >> 1] + (i & 1);
        return f;
    }

    public int[] countBitsDp(int num) {
        if (num == 0)
            return new int[]{0};

        int[] result = new int[num + 1];
        int offset = 1;

        for (int i = 1; i <= num; i++) {
            if (2 * offset == i) {
                offset *=2;
            }

            result[i] = 1 + result[i - offset];
        }

        return result;
    }

    public int[] countBitsDivide(int num) {
        int[] result = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            int k = i;
            while (k != 0) {
                if (k % 2 != 0)
                    result[i]++;
                k /= 2;
            }
        }
        return result;
    }

    public int[] countBitsNative(int num) {
        int[] result = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            result[i] = Integer.bitCount(i);
        }
        return result;
    }
}
