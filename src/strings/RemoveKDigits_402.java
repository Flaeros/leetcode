package strings;

import java.util.Stack;

public class RemoveKDigits_402 {

    public static void main(String[] args) {
        System.out.println(new RemoveKDigits_402().removeKdigits("1432219", 3));
        System.out.println(new RemoveKDigits_402().removeKdigits("10200", 1));
        System.out.println(new RemoveKDigits_402().removeKdigits("10", 2));
        System.out.println(new RemoveKDigits_402().removeKdigits("10", 1));
    }

    public String removeKdigits(String num, int k) {
        if (k == num.length())
            return "0";

        Stack<Character> stack = new Stack<>();

        int i = 0;
        while (i < num.length()) {
            while (k > 0 && !stack.isEmpty() && stack.peek() > num.charAt(i)) {
                stack.pop();
                k--;
            }

            stack.push(num.charAt(i++));
        }

        while (k>0) {
            stack.pop();
            k--;
        }


        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        while (sb.length() > 0 && sb.charAt(sb.length()-1) == '0') {
            sb.deleteCharAt(sb.length()-1);
        }

        String s = sb.reverse().toString();
        return s.isEmpty() ? "0" : s;
    }
}
