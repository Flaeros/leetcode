package array;

import java.util.PriorityQueue;

/**
 * We have a collection of stones, each stone has a positive integer weight.
 * <p>
 * Each turn, we choose the two heaviest stones and smash them together.  Suppose the stones have weights x and y with x <= y.  The result of this smash is:
 * <p>
 * If x == y, both stones are totally destroyed;
 * If x != y, the stone of weight x is totally destroyed, and the stone of weight y has new weight y-x.
 * At the end, there is at most 1 stone left.  Return the weight of this stone (or 0 if there are no stones left.)
 */
public class LastStoneWeight_1046 {

    /**
     * 1 <= stones.length <= 30
     * 1 <= stones[i] <= 1000
     */
    public static void main(String[] args) {
        System.out.println(new LastStoneWeight_1046().lastStoneWeight(new int[]{2, 7, 4, 1, 8, 1}));
        System.out.println(new LastStoneWeight_1046().lastStoneWeight(new int[]{2, 7, 4, 2, 8, 1}));

    }

    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((o1, o2) -> (o2-o1));
        for (int stone : stones) {
            heap.add(stone);
        }

        while (heap.size() > 1) {
            heap.add(Math.abs(heap.poll() - heap.poll()));
        }

        return heap.poll();
    }
}
