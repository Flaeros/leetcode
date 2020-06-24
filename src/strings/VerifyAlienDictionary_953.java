package strings;

public class VerifyAlienDictionary_953 {

    public static void main(String[] args) {
        System.out.println(new VerifyAlienDictionary_953().isAlienSorted(new String[]{"hello", "leetcode"}, "hlabcdefgijkmnopqrstuvwxyz"));
        System.out.println(new VerifyAlienDictionary_953().isAlienSorted(new String[]{"word", "world", "row"}, "worldabcefghijkmnpqstuvxyz"));
        System.out.println(new VerifyAlienDictionary_953().isAlienSorted(new String[]{"apple", "app"}, "abcdefghijklmnopqrstuvwxyz"));
    }

    public boolean isAlienSorted(String[] words, String order) {
        int[] mapping = new int[26];
        for (int i = 0; i < order.length(); i++) {
            mapping[order.charAt(i) - 'a'] = i;
        }

        for (int i = 1; i < words.length; i++) {
            if (bigger(words[i - 1], words[i], mapping))
                return false;
        }
        return true;
    }

    private boolean bigger(String a, String b, int[] mapping) {
        int n = a.length();
        int m = b.length();

        for (int i = 0; i < n && i < m; i++) {
            if (a.charAt(i) != b.charAt(i))
                return mapping[a.charAt(i) - 'a'] > mapping[b.charAt(i) - 'a'];
        }
        return n > m;
    }

    public boolean isAlienSorted2(String[] words, String order) {
        int len = words.length;
        if (len == 0)
            return true;
        if (order.isEmpty())
            return false;

        int max = 0;
        for (String word : words) {
            max = Math.max(max, word.length());
        }

        for (int j = 0; j < len - 1; j++) {
            for (int i = 0; i < max; i++) {
                Character a = null;
                Character b = null;
                if (words[j].length() > i)
                    a = words[j].charAt(i);
                if (words[j + 1].length() > i)
                    b = words[j + 1].charAt(i);
                if (a != null && b == null) {
                    return false;
                } else if (a == null & b != null) {
                    break;
                } else if (a != null) {
                    int ai = order.indexOf(a);
                    int bi = order.indexOf(b);
                    if (ai > bi)
                        return false;
                    if (ai == bi)
                        continue;
                    break;
                }
            }
        }

        return true;
    }
}
