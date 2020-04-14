package strings;

/**
 * You are given a string s containing lowercase English letters, and a matrix shift, where shift[i] = [direction, amount]:
 * <p>
 * direction can be 0 (for left shift) or 1 (for right shift).
 * amount is the amount by which string s is to be shifted.
 * A left shift by 1 means remove the first character of s and append it to the end.
 * Similarly, a right shift by 1 means remove the last character of s and add it to the beginning.
 * Return the final string after all operations.
 */
public class StringShifts {

    /**
     * 1 <= s.length <= 100
     * s only contains lower case English letters.
     * 1 <= shift.length <= 100
     * shift[i].length == 2
     * 0 <= shift[i][0] <= 1
     * 0 <= shift[i][1] <= 100
     */
    public static void main(String[] args) {
        System.out.println(new StringShifts().stringShift("abc", new int[][]{{0, 1}, {1, 2}}));
        System.out.println(new StringShifts().stringShift("abcdefg", new int[][]{{1, 1}, {1, 1}, {0, 2}, {1, 3}}));
        System.out.println(new StringShifts().stringShift("yisxjwry", new int[][]{{1, 8}, {1, 4}, {1, 3}, {1, 6}, {0, 6}, {1, 4}, {0, 2}, {0, 1}}));
    }

    public String stringShift(String s, int[][] shift) {
        int total = 0;
        for (int[] ints : shift) {
            if (ints[0] == 1)
                total = total + ints[1];
            else
                total = total - ints[1];
        }
        total = total % s.length();
        if (total == 0)
            return s;
        if (total > 0)
            return s.substring(s.length() - total) + s.substring(0, s.length() - total);

        return s.substring(-1 * total) + s.substring(0, -1 * total);
    }
}
