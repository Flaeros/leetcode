package strings;

import java.util.Stack;

/**
 * Given two strings S and T, return if they are equal
 * when both are typed into empty text editors.
 * # means a backspace character.
 */
public class BackspaceStringCompare_844 {
    /**
     * Note:
     * <p>
     * 1 <= S.length <= 200
     * 1 <= T.length <= 200
     * S and T only contain lowercase letters and '#' characters.
     * Follow up:
     * <p>
     * Can you solve it in O(N) time and O(1) space?
     */
    public static void main(String[] args) {
        System.out.println(new BackspaceStringCompare_844().backspaceCompare("ab#c", "ad#c"));
        System.out.println(new BackspaceStringCompare_844().backspaceCompare("ab##", "c#d#"));
        System.out.println(new BackspaceStringCompare_844().backspaceCompare("a##c", "#a#c"));
        System.out.println(new BackspaceStringCompare_844().backspaceCompare("a#c", "b"));
        System.out.println(new BackspaceStringCompare_844().backspaceCompare("y#fo##f", "y#f#o##f"));
    }

    public boolean backspaceCompare(String S, String T) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '#') {
                if (!stack.isEmpty())
                    stack.pop();
            } else
                stack.push(S.charAt(i));
        }
        StringBuilder s2builder = new StringBuilder();
        while (!stack.isEmpty()) {
            s2builder.append(stack.pop());
        }

        String S2 = s2builder.toString();


        for (int i = 0; i < T.length(); i++) {
            if (T.charAt(i) == '#') {
                if (!stack.isEmpty())
                    stack.pop();
            } else
                stack.push(T.charAt(i));
        }
        StringBuilder t2builder = new StringBuilder();
        while (!stack.isEmpty()) {
            t2builder.append(stack.pop());
        }

        String T2 = t2builder.toString();

        return S2.equals(T2);
    }
}
