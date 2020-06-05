package array;

import java.util.Random;

public class RandomPickWithWeight_528 {

    public static void main(String[] args) {
        Solution solution = new Solution(new int[]{1});
        System.out.println(solution.pickIndex());

        System.out.println();

        solution = new Solution(new int[]{1, 3});
        System.out.println(solution.pickIndex());
        System.out.println(solution.pickIndex());
        System.out.println(solution.pickIndex());
        System.out.println(solution.pickIndex());
        System.out.println(solution.pickIndex());

        System.out.println();

        solution = new Solution(new int[]{3, 14, 1, 7});
        System.out.println(solution.pickIndex());
        System.out.println(solution.pickIndex());
        System.out.println(solution.pickIndex());
        System.out.println(solution.pickIndex());
        System.out.println(solution.pickIndex());


    }

    public static class Solution {

        int[] dist;
        Random random;

        public Solution(int[] w) {
            random = new Random();
            for (int i = 1; i < w.length; ++i)
                w[i] += w[i - 1];
            dist = w;

        }

        public int pickIndex() {
            int len = dist.length;
            int next = random.nextInt(dist[len - 1]) + 1;

            int left = 0;
            int right = len - 1;
            while (left < right) {
                int mid = left + (right - left) / 2;

                if (dist[mid] == next) {
                    return mid;
                } else if (dist[mid] < next) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }

            return left;
        }
    }
}
