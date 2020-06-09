package strings;

public class IsSubsequence_392 {

    public static void main(String[] args) {
        System.out.println(new IsSubsequence_392().isSubsequence("abc", "ahbgdc"));
        System.out.println(new IsSubsequence_392().isSubsequence("axc", "ahbgdc"));
    }

    public boolean isSubsequence(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();
        if (sLen == 0)
            return true;
        if (tLen == 0)
            return false;

        int count = 0;
        int index = 0;

        for (int j = 0; j < tLen; j++) {
            if (count == sLen)
                return true;
            if(t.charAt(j) == s.charAt(index)) {
                index++;
                count++;
            }
        }

        return count == sLen;
    }
}
