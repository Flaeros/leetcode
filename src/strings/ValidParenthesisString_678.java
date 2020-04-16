package strings;

/**
 * Given a string containing only three types of characters: '(', ')' and '*', write a function to check whether this string is valid. We define the validity of a string by these rules:
 * <p>
 * Any left parenthesis '(' must have a corresponding right parenthesis ')'.
 * Any right parenthesis ')' must have a corresponding left parenthesis '('.
 * Left parenthesis '(' must go before the corresponding right parenthesis ')'.
 * '*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string.
 * An empty string is also valid.
 */
public class ValidParenthesisString_678 {

    /**
     * The string size will be in the range [1, 100].
     */
    public static void main(String[] args) {
        System.out.println(new ValidParenthesisString_678().checkValidString("()"));
        System.out.println(new ValidParenthesisString_678().checkValidString("(*)"));
        System.out.println(new ValidParenthesisString_678().checkValidString("(*))"));
        System.out.println(new ValidParenthesisString_678().checkValidString("((*)"));
    }

    public boolean checkValidString(String s) {
        int min = 0;
        int max = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                //increment
                max++;
                min++;
            } else if (c == ')') {
                //decrement
                max--;
                min = Math.max(min - 1, 0);
            } else {
                // *
                max++; //might need closing
                min = Math.max(min - 1, 0); //might close opening
            }

            //too many closings
            if (max < 0) {
                return false;
            }
        }

        //all matched
        return min == 0;
    }
}
