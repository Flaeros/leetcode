package strings;

import java.util.Arrays;
import java.util.Comparator;

public class CustomSortString_791 {

    public static void main(String[] args) {
        System.out.println(new CustomSortString_791().customSortString("cba", "abcd"));
    }

    public String customSortString(String S, String T) {
        int[] sort = new int[26];
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            sort[c - 'a'] = i + 1;
        }


        Comparator<Character> comparator = Comparator.comparingInt(c -> sort[c -'a']);

        Character[] chars = T.chars().mapToObj(c -> (char) c).toArray(Character[]::new);
        Arrays.sort(chars, comparator);

        char[] result = new char[chars.length];

        for (int i = 0; i < chars.length; i++) {
            result[i] = chars[i];
        }

        return new String(result);
    }
}
