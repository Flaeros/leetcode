package strings;

import java.util.ArrayList;
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

        int count = p.length();
        for (int i = 0; i < slen; i++) {
            if ( pmemo[s.charAt(i) - 'a']-- >=1)
                count--;

            if (i >= plen) {
                if (pmemo[s.charAt(i - plen) - 'a']++  >=0)
                    count++;
            }

            if (i >= plen - 1) {
                if (count == 0)
                    result.add(i + 1 - plen);
            }
        }

        return result;
    }

    private boolean empty(int[] pmemo) {
        for (int i : pmemo) {
            if (i != 0)
                return false;
        }
        return true;
    }

}
