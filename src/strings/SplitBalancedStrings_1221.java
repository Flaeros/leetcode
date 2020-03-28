package strings;

/**
 * Balanced strings are those who have equal quantity of 'L' and 'R' characters.
 * Given a balanced string s split it in the maximum amount of balanced strings.
 * Return the maximum amount of splitted balanced strings.
 */
public class SplitBalancedStrings_1221 {
    /**
     * 1 <= s.length <= 1000
     * s[i] = 'L' or 'R'
     */
    public static void main(String[] args) {
        System.out.println(new SplitBalancedStrings_1221().balancedStringSplit("RLRRLLRLRL"));
        System.out.println(new SplitBalancedStrings_1221().balancedStringSplit("RLLLLRRRLR"));
        System.out.println(new SplitBalancedStrings_1221().balancedStringSplit("LLLLRRRR"));
        System.out.println(new SplitBalancedStrings_1221().balancedStringSplit("RLRRRLLRLL"));
    }

    public int balancedStringSplit(String s) {
        if (s.length() % 2 != 0)
            return 0;

        int ls = 0;
        int rs = 0;
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == 'L')
                ls++;
            if (c == 'R')
                rs++;

            if (ls == rs && ls != 0 && rs != 0) {
                count++;
                ls = 0;
                rs = 0;
            }
        }

        if (ls > 0 || rs > 0)
            return 0;

        return count;
    }
}
