package tree;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class CheapestFlightsWithinKStops_787 {

    public static void main(String[] args) {
        System.out.println(new CheapestFlightsWithinKStops_787().findCheapestPrice(
                3, new int[][]{{0, 1, 100}, {1, 2, 100}, {0, 2, 500}}, 0, 2, 1));
        System.out.println(new CheapestFlightsWithinKStops_787().findCheapestPrice(
                3, new int[][]{{0, 1, 100}, {1, 2, 100}, {0, 2, 500}}, 0, 2, 0));
        System.out.println(new CheapestFlightsWithinKStops_787().findCheapestPrice(
                5, new int[][]{{4, 1, 1}, {1, 2, 3}, {0, 3, 2}, {0, 4, 10}, {3, 1, 1}, {1, 4, 3}}, 2, 1, 1));
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        Map<Integer, Map<Integer, Integer>> prices = new HashMap<>();

        for (int[] flight : flights) {
            //(src, dst, price)
            if (!prices.containsKey(flight[0]))
                prices.put(flight[0], new HashMap<>());
            prices.get(flight[0]).put(flight[1], flight[2]);
        }

        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
        queue.offer(new int[]{0, src, K + 1});

        while (!queue.isEmpty()) {
            int[] next = queue.poll();
            int price = next[0];
            int city = next[1];
            int steps = next[2];

            if (city == dst)
                return price;

            if (steps > 0) {
                Map<Integer, Integer> possible = prices.get(city);
                if (possible == null)
                    continue;
                for (Integer dest : possible.keySet()) {
                    queue.offer(new int[]{price + possible.get(dest), dest, steps - 1});
                }
            }
        }

        return -1;
    }
}
