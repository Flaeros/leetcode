package array;

public class MaxConsecutiveOnes3_1004 {

    public static void main(String[] args) {
        System.out.println(new MaxConsecutiveOnes3_1004().longestOnes(new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, 2));
        System.out.println(new MaxConsecutiveOnes3_1004().longestOnes(new int[]{0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1}, 3));
    }


    public int longestOnes(int[] A, int K) {
        int i = 0;
        int j = 0;
        int countZero = 0;
        int result = 0;
        int current = 0;

        while (j < A.length) {
            if (A[j] == 1) {
                current++;
                result = Math.max(result, current);
                j++;
            } else {
                countZero++;
                j++;
                if (countZero <= K) {
                    current++;
                    result = Math.max(result, current);
                } else {
                    while (countZero > K && i <= j) {
                        if (A[i++] == 1) {
                            current--;
                        } else {
                            countZero--;
                        }
                    }
                }
            }
        }


        return result;
    }
}
