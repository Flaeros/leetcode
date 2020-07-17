package math;

import java.util.*;

public class Top_K_Frequent_Elements_347 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Top_K_Frequent_Elements_347().topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2)));
        System.out.println(Arrays.toString(new Top_K_Frequent_Elements_347().topKFrequent(new int[]{1}, 1)));
    }

    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.merge(num, 1, (prev, curr) -> prev + 1);
        }

        PriorityQueue<int[]> numbers = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));

        for (Integer number : map.keySet()) {
            Integer freq = map.get(number);
            if (numbers.size() >= k) {
                if (numbers.peek()[1] < freq) {
                    numbers.poll();
                    numbers.offer(new int[]{number, freq});
                }
            } else {
                numbers.offer(new int[]{number, freq});
            }
        }

        int[] result = new int[k];

        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = numbers.poll()[0];
        }
        return result;
    }
}
