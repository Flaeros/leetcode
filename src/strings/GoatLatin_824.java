package strings;

import java.util.HashSet;
import java.util.Set;

import static java.util.Arrays.asList;

public class GoatLatin_824 {

    public static void main(String[] args) {
        System.out.println(new GoatLatin_824().toGoatLatin("I speak Goat Latin"));
        System.out.println(new GoatLatin_824().toGoatLatin("The quick brown fox jumped over the lazy dog"));
    }

    public String toGoatLatin(String S) {
        String[] words = S.split(" ");
        Set<Character> vowels = new HashSet<>(asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (vowels.contains(word.charAt(0))) {
                sb.append(word);
                sb.append("ma");
                sb.append("a".repeat(i + 1));
            } else {
                sb.append(word.substring(1));
                sb.append(word.charAt(0));
                sb.append("ma");
                sb.append("a".repeat(i + 1));
            }

            if (i != words.length - 1) {
                sb.append(" ");
            }
        }

        return sb.toString();
    }
}
