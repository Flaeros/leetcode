package array;

import java.util.Comparator;
import java.util.PriorityQueue;

import static array.MaximalSquare_221.printDim;

public class KClosestPointsToOrigin_973 {

    public static void main(String[] args) {
        System.out.println(printDim(new KClosestPointsToOrigin_973().kClosest(new int[][]{{0, 1}, {1, 0}}, 2)));
        System.out.println(printDim(new KClosestPointsToOrigin_973().kClosest(new int[][]{{1, 3}, {2, 2}}, 1)));
        System.out.println(printDim(new KClosestPointsToOrigin_973().kClosest(new int[][]{{3, 3}, {5, -1}, {-2, 4}}, 2)));
    }

    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> heap = new PriorityQueue<>(getComparator());

        for (int[] point : points) {
            heap.offer(point);
            if (heap.size() > K)
                heap.poll();
        }

        int[][] result = new int[K][2];
        for (int i = 0; i < K; i++) {
            result[i] = heap.poll();
        }

        return result;
    }

    private Comparator<int[]> getComparator() {
        return (p1, p2) -> distance(p2[0], p2[1]) - distance(p1[0], p1[1]);
    }


    int distance(int x, int y) {
        return x * x + y * y;
    }
}
