package math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumbersWithSameConsecutiveDifferences_967 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new NumbersWithSameConsecutiveDifferences_967().numsSameConsecDiff(3, 7)));
        System.out.println(Arrays.toString(new NumbersWithSameConsecutiveDifferences_967().numsSameConsecDiff(2, 1)));
    }

    public int[] numsSameConsecDiff(int N, int K) {
        List<Integer> result = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);

        for (int i = 2; i <= N; i++) {
            List<Integer> next = new ArrayList<>();
            for (Integer number : result) {
                int digit = number % 10;
                if (number > 0 && digit + K < 10) {
                    next.add(number * 10 + digit + K);
                }
                if (number > 0 && K > 0 && digit - K >= 0) {
                    next.add(number * 10 + digit - K);
                }
                result = next;
            }
        }
        return result.stream().mapToInt(i -> i).toArray();
    }
}
