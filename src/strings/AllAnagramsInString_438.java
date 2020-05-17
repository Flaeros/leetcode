package strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
 * <p>
 * Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.
 * <p>
 * The order of output does not matter.
 */
public class AllAnagramsInString_438 {

    public static void main(String[] args) {
        System.out.println(new AllAnagramsInString_438().findAnagrams("cbaebabacd", "abc"));
        System.out.println(new AllAnagramsInString_438().findAnagrams("abab", "ab"));
    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();

        int slen = s.length();
        int plen = p.length();

        int[] pmemo = new int[26];
        for (int i = 0; i < plen; i++) {
            pmemo[p.charAt(i) - 'a']++;
        }

        for (int i = 0; i <= slen - plen; i++) {
            if (isAnagram(s, i, i + plen, Arrays.copyOf(pmemo, 26)))
                result.add(i);
        }

        return result;
    }

    private boolean isAnagram(String s, int start, int end, int[] memo) {
        for (int i = start; i < end; i++) {
            memo[s.charAt(i) -'a']--;
        }

        for (int val : memo) {
            if(val != 0)
                return false;
        }
        return true;
    }
}
