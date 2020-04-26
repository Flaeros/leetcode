package strings;

/**
 * Given two strings text1 and text2, return the length of their longest common subsequence.
 * <p>
 * A subsequence of a string is a new string generated from the original string with some characters(can be none)
 * deleted without changing the relative order of the remaining characters. (eg, "ace" is a subsequence of "abcde"
 * while "aec" is not). A common subsequence of two strings is a subsequence that is common to both strings.
 * If there is no common subsequence, return 0.
 */
public class LongestCommonSubsequence {

    /**
     * 1 <= text1.length <= 1000
     * 1 <= text2.length <= 1000
     * The input strings consist of lowercase English characters only.
     */
    public static void main(String[] args) {
        System.out.println(new LongestCommonSubsequence().longestCommonSubsequence("abcde", "ace"));
        System.out.println(new LongestCommonSubsequence().longestCommonSubsequence("abc", "abc"));
        System.out.println(new LongestCommonSubsequence().longestCommonSubsequence("abc", "def"));
    }

    public int longestCommonSubsequence(String text1, String text2) {
        if (text1.length() < text2.length())
            return longestCommonSubsequence(text2, text1);

        int[][] res = new int[2][text2.length() + 1];

        for (int i = 1; i <= text1.length(); i++) {
            for (int j = 1; j <= text2.length(); j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    res[i % 2][j] = res[(i - 1) % 2][j - 1] + 1;
                } else {
                    res[i % 2][j] = Math.max(res[(i - 1) % 2][j], res[i % 2][j - 1]);
                }
            }
        }

        return res[text1.length() % 2][text2.length()];
    }
}
