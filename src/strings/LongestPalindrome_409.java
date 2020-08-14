package strings;

public class LongestPalindrome_409 {

    public static void main(String[] args) {
        System.out.println(new LongestPalindrome_409().longestPalindrome("abccccdd"));
        System.out.println(new LongestPalindrome_409().longestPalindrome("zeusnilemacaronimaisanitratetartinasiaminoracamelinsuez"));
    }

    public int longestPalindrome(String s) {
        int[] chars = new int[52];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int pos = c - 'a';
            if (pos >= 0) {
                chars[pos]++;
            } else {
                pos = c - 'A' + 26;
                chars[pos]++;
            }
        }

        int odds = 0;
        int result = 0;
        for (int charCount : chars) {
            if (charCount == 0) {
                continue;
            }
            if (charCount % 2 == 0) {
                result += charCount;
            } else {
                result += charCount - 1;
                odds++;
            }
        }

        return odds > 0 ? result + 1 : result;
    }
}
