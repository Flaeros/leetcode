package strings;

/**
 * Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1.
 * In other words, one of the first string's permutations is the substring of the second string.
 */
public class PermutationInString_567 {
    public static void main(String[] args) {
        System.out.println(new PermutationInString_567().checkInclusion("ab", "eidbaooo"));
        System.out.println(new PermutationInString_567().checkInclusion("ab", "eidboaoo"));
        System.out.println(new PermutationInString_567().checkInclusion("adc", "daadca"));
        System.out.println(new PermutationInString_567().checkInclusion("adc", "dcda"));
    }

    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;

        int len = s1.length();
        int[] memo = new int[26];

        int count = s1.length();

        for (int i = 0; i < len; i++) {
            memo[s1.charAt(i) - 'a']++;
        }

        int start = 0, end = 0;

        while (end < s2.length()) {

            if (memo[s2.charAt(end++) - 'a']-- >= 1) {
                count--;
            }

            if (end - start > len && memo[s2.charAt(start++) - 'a']++ >= 0) {
                count++;
            }

            if (end - start == len && count == 0)
                return true;
        }

        return false;
    }
}
