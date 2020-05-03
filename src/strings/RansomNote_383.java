package strings;

public class RansomNote_383 {
    public static void main(String[] args) {
        System.out.println(new RansomNote_383().canConstruct("a", "b"));
        System.out.println(new RansomNote_383().canConstruct("aa", "ab"));
        System.out.println(new RansomNote_383().canConstruct("aa", "aab"));
        System.out.println(new RansomNote_383().canConstruct("bjaajgea",
                "affhiiicabhbdchbidghccijjbfjfhjeddgggbajhidhjchiedhdibgeaecffbbbefiabjdhggihccec"));
    }

    public boolean canConstruct(String ransomNote, String magazine) {

        int []memo = new int[27];

        for (int i = 0; i < magazine.length(); i++) {
            memo[magazine.charAt(i) - 'a']++;
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            char key = ransomNote.charAt(i);
            if (memo[key-'a'] > 0) {
                memo[key-'a']--;
            } else
                return false;
        }

        return true;
    }
}
