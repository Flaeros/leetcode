package strings;

public class DetectCapital_520 {

    public static void main(String[] args) {
        System.out.println(new DetectCapital_520().detectCapitalUse("uSA"));
        System.out.println(new DetectCapital_520().detectCapitalUse("FlaG"));
        System.out.println(new DetectCapital_520().detectCapitalUse("USA"));
        System.out.println(new DetectCapital_520().detectCapitalUse("Google"));
        System.out.println(new DetectCapital_520().detectCapitalUse("leetcode"));
    }

    public boolean detectCapitalUse(String word) {
        if (word == null || word.length() == 0)
            return true;

        if (word.length() == 1)
            return true;

        for (int i = 0; i < word.length() - 1; i++) {
            boolean current = isCapital(word.charAt(i));
            boolean next = isCapital(word.charAt(i + 1));
            if (current != next) {
                if (i == 0 && current)
                    continue;
                return false;
            }
        }

        return true;
    }

    boolean isCapital(char c) {
        return c - 'A' >= 0 && c - 'Z' <= 0;
    }
}
