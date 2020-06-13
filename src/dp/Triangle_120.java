package dp;

import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;

public class Triangle_120 {

    public static void main(String[] args) {
        System.out.println(new Triangle_120().minimumTotal(asList(
                asList(2),
                asList(3, 4),
                asList(6, 5, 7),
                asList(4, 1, 8, 3))));
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int[] dp = new int[triangle.size() + 1];
        for (int i = triangle.size() - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }

    public int minimumTotalTop(List<List<Integer>> triangle) {
        if (triangle.size() == 0)
            return 0;
        Integer[] curr = new Integer[2];
        List<Integer> pre = triangle.get(0);

        for (int i = 1; i < triangle.size(); i++) {
            List<Integer> next = triangle.get(i);
            for (int j = 0; j < pre.size(); j++) {
                Integer val = pre.get(j);
                if (curr[j] != null)
                    curr[j] = Math.min(curr[j], val + next.get(j));
                else
                    curr[j] = val + next.get(j);
                curr[j + 1] = val + next.get(j + 1);
            }
            pre = Arrays.asList(curr);
            curr = new Integer[i + 2];
        }

        int min = Integer.MAX_VALUE;
        for (Integer dist : pre) {
            min = Math.min(min, dist);
        }

        return min;
    }
}
