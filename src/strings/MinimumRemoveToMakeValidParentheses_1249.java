package strings;

import java.util.Stack;

public class MinimumRemoveToMakeValidParentheses_1249 {

    public static void main(String[] args) {
        System.out.println(new MinimumRemoveToMakeValidParentheses_1249().minRemoveToMakeValid("lee(t(c)o)de)"));
        System.out.println(new MinimumRemoveToMakeValidParentheses_1249().minRemoveToMakeValid("lee(t(c)o)de)"));
        System.out.println(new MinimumRemoveToMakeValidParentheses_1249().minRemoveToMakeValid("a)b(c)d"));
        System.out.println(new MinimumRemoveToMakeValidParentheses_1249().minRemoveToMakeValid("))(("));
        System.out.println(new MinimumRemoveToMakeValidParentheses_1249().minRemoveToMakeValid("(a(b(c)d)"));
    }

    public String minRemoveToMakeValid(String s) {
        Stack<Integer> st = new Stack<>();
        StringBuilder sb = new StringBuilder(s);

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                st.push(i);
            } else if (c == ')') {
                if (st.isEmpty()) {
                    sb.setCharAt(i, '*');
                } else {
                    st.pop();
                }
            }
        }

        while (!st.isEmpty()) {
            sb.setCharAt(st.pop(), '*');
        }

        return sb.toString().replaceAll("\\*", "");
    }

    public String minRemoveToMakeValid2(String s) {

        int opening = 0;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ')') {
                if (opening > 0) {
                    sb.append(c);
                    opening--;
                }
            } else if (c == '(') {
                opening++;
                sb.append(c);
            } else {
                sb.append(c);
            }
        }

        s = sb.toString();

        int closing = 0;
        sb = new StringBuilder();

        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == '(') {
                if (closing > 0) {
                    sb.append(c);
                    closing--;
                }
            } else if (c == ')') {
                closing++;
                sb.append(c);
            } else {
                sb.append(c);
            }
        }


        return sb.reverse().toString();
    }
}
