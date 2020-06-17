package strings;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses_20 {

    public static void main(String[] args) {
        System.out.println(new ValidParentheses_20().isValid("){"));
        System.out.println(new ValidParentheses_20().isValid("()"));
        System.out.println(new ValidParentheses_20().isValid("()[]{}"));
        System.out.println(new ValidParentheses_20().isValid("(]"));
        System.out.println(new ValidParentheses_20().isValid("([)]"));
        System.out.println(new ValidParentheses_20().isValid("{[]}"));
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }

        return stack.isEmpty();
    }

    public boolean isValid2(String s) {
        if (s.length() == 0)
            return true;
        if (s.length() % 2 != 0)
            return false;
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> opening = new HashMap<>();
        opening.put('(', ')');
        opening.put('[', ']');
        opening.put('{', '}');
        Map<Character, Character> closing = new HashMap<>();
        closing.put(')', '(');
        closing.put(']', '[');
        closing.put('}', '{');

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (opening.containsKey(c)) {
                stack.push(c);
                continue;
            }
            if (closing.containsKey(c)) {
                if (stack.isEmpty())
                    return false;
                Character pop = stack.pop();
                if (closing.get(c) != pop) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
