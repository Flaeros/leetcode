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

        int count = 0;
        int balance = 0;

        for (int i = 0; i < s.length(); i++) {
            balance += s.charAt(i) == 'L' ? 1 : -1;
            if (balance == 0)
                count++;
        }

        return count;
    }
}
