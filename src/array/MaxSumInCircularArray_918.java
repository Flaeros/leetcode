package array;

public class MaxSumInCircularArray_918 {
    public static void main(String[] args) {
        System.out.println(new MaxSumInCircularArray_918().maxSubarraySumCircular(new int[]{1, -2, 3, -2}));
        System.out.println(new MaxSumInCircularArray_918().maxSubarraySumCircular(new int[]{5, -3, 5}));
        System.out.println(new MaxSumInCircularArray_918().maxSubarraySumCircular(new int[]{3, -1, 2, -1}));
        System.out.println(new MaxSumInCircularArray_918().maxSubarraySumCircular(new int[]{3, -2, 2, -3}));
        System.out.println(new MaxSumInCircularArray_918().maxSubarraySumCircular(new int[]{-2, -3, -1}));
    }

    /**
     * -30000 <= A[i] <= 30000
     * 1 <= A.length <= 30000
     */
    public int maxSubarraySumCircular(int[] A) {
        int currentMax = 0;
        int maxSum = -30000;

        int currentMin = 0;
        int minSum = 30000;

        int totalMax = 0;

        for (int a : A) {
            currentMax = Math.max(currentMax + a, a);
            maxSum = Math.max(maxSum, currentMax);

            currentMin = Math.min(currentMin + a, a);
            minSum = Math.min(minSum, currentMin);

            totalMax += a;
        }

        if(maxSum > 0)
            return Math.max(maxSum, totalMax - minSum);

        return maxSum;
    }

    public int maxSubarraySumCircular2(int[] A) {
        int currentMax = 0;
        int currentMin = 0;
        int totalMax = 0;
        int maxSum = -30000;
        int minSum = 30000;

        for (int a : A) {
            currentMax = Math.max(currentMax + a, a);
            maxSum = Math.max(maxSum, currentMax);

            currentMin = Math.min(currentMin + a, a);
            minSum = Math.min(minSum, currentMin);

            totalMax += a;
        }

        if (maxSum > 0) {
            return Math.max(maxSum, totalMax - minSum);
        }

        return maxSum;
    }
}
