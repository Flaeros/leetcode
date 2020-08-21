package array;

import java.util.Arrays;

public class SortArrayByParity_905 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new SortArrayByParity_905().sortArrayByParity(new int[]{2, 4, 6, 8})));
        System.out.println(Arrays.toString(new SortArrayByParity_905().sortArrayByParity(new int[]{3, 1, 2, 4})));
        System.out.println(Arrays.toString(new SortArrayByParity_905().sortArrayByParity(new int[]{1, 2, 3, 4})));
        System.out.println(Arrays.toString(new SortArrayByParity_905().sortArrayByParity(new int[]{1, 3, 5, 7})));
    }

    public int[] sortArrayByParity(int[] A) {
        if (A.length == 0)
            return A;

        int low = 0;
        int high = A.length - 1;

        while (low < A.length && low < high) {
            while (low < A.length - 1 && A[low] % 2 == 0) {
                low++;
            }
            while (high > 0 && A[high] % 2 != 0) {
                high--;
            }

            if (A[low] % 2 != 0 && low < high) {
                int temp = A[low];
                A[low] = A[high];
                A[high] = temp;

                low++;
                high--;
            }
        }
        return A;
    }
}
