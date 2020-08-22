package math;

import java.util.Arrays;
import java.util.Random;
import java.util.TreeMap;

public class RandomPointInNonOverlappingRectangles_497 {


    public static void main(String[] args) {
        Solution solution = new Solution(new int[][]{
                {1, 1, 5, 5}
        });
        System.out.println(Arrays.toString(solution.pick()));
        System.out.println(Arrays.toString(solution.pick()));
        System.out.println(Arrays.toString(solution.pick()));

        System.out.println("next");

        solution = new Solution(new int[][]{
                {-2, -2, -1, -1}, {1, 0, 3, 0}
        });
        System.out.println(Arrays.toString(solution.pick()));
        System.out.println(Arrays.toString(solution.pick()));
        System.out.println(Arrays.toString(solution.pick()));
        System.out.println(Arrays.toString(solution.pick()));
        System.out.println(Arrays.toString(solution.pick()));
    }

    static class Solution {
        int area;
        TreeMap<Integer, Integer> map;
        int[][] rects;
        Random random;

        public Solution(int[][] rects) {
            this.rects = rects;
            random = new Random();
            map = new TreeMap<>();
            area = 0;

            for (int i = 0; i < rects.length; i++) {
                int[] rect = rects[i];
                //rects[i] = [x1,y1,x2,y2]
                area += (rect[2] - rect[0] + 1) * (rect[3] - rect[1] + 1);
                map.put(area, i);
            }
        }

        public int[] pick() {
            int next = random.nextInt(area);
            int currArea = map.higherKey(next);
            int[] rect = rects[map.get(currArea)];

            //rects[i] = [x1,y1,x2,y2]
            int shift = currArea - next;
            int width = rect[2] - rect[0];
            int dx = (shift - 1) % (width + 1);
            int dy = (shift - 1) / (width + 1);

            return new int[]{rect[0] + dx, rect[1] + dy};
        }
    }
}
