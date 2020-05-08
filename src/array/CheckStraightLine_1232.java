package array;

/**
 * You are given an array coordinates, coordinates[i] = [x, y],
 * where [x, y] represents the coordinate of a point.
 * Check if these points make a straight line in the XY plane.
 */
public class CheckStraightLine_1232 {
    public static void main(String[] args) {
        System.out.println(new CheckStraightLine_1232().checkStraightLine(new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}, {6, 7}}));
        System.out.println(new CheckStraightLine_1232().checkStraightLine(new int[][]{{1, 1}, {2, 2}, {3, 4}, {4, 5}, {5, 6}, {7, 7}}));
        System.out.println(new CheckStraightLine_1232().checkStraightLine(new int[][]{{-3, -2}, {-1, -2}, {2, -2}, {-2, -2}, {0, -2}}));
        System.out.println(new CheckStraightLine_1232().checkStraightLine(new int[][]{{-5, 1}, {-4, -1}, {-7, 4}, {-7, -7}, {5, -7}, {-3, 2}, {2, -5}}));
    }

    public boolean checkStraightLine(int[][] coordinates) {
        if (coordinates.length <= 2)
            return true;

        int[] prev = coordinates[0];
        int[] curr = coordinates[1];

        for (int i = 1; i < coordinates.length - 1; i++) {
            int[] next = coordinates[i + 1];

            int firstX = curr[0] - prev[0];
            int firstY = curr[1] - prev[1];

            int secondX = next[0] - curr[0];
            int secondY = next[1] - curr[1];

            if (firstX * secondY != secondX * firstY)
                return false;
        }
        return true;
    }
}
