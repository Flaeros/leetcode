package strings;

import java.util.Arrays;

public class FirstUniqueCharacter_387 {

    public static void main(String[] args) {
        System.out.println(new FirstUniqueCharacter_387().firstUniqChar("leetcode"));
        System.out.println(new FirstUniqueCharacter_387().firstUniqChar("loveleetcode"));
    }

    public int firstUniqChar(String s) {
        int[] memo = new int[26];
        int[] pos = new int[26];
        Arrays.fill(pos, -1);

        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'a';
            if (pos[c] == -1)
                pos[c] = i;
            memo[c]++;
        }

        int res = -1;
        for (int i = 0; i < memo.length; i++) {
            if (memo[i] == 1) {
                if (pos[i] != -1) {
                    if (res == -1)
                        res = pos[i];
                    else
                        res = Math.min(res, pos[i]);
                }

            }
        }

        return res;
    }
}
