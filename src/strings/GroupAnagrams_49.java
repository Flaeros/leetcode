package strings;

import java.util.*;

/**
 * Given an array of strings, group anagrams together.
 */
public class GroupAnagrams_49 {
    public static void main(String[] args) {
        System.out.println(printDim(new GroupAnagrams_49().groupAnagrams(new String[]{"boo", "bob"})));
        System.out.println(printDim(new GroupAnagrams_49().groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"})));
        System.out.println(printDim(new GroupAnagrams_49().groupAnagrams(new String[]{"cab", "tin", "pew", "duh", "may", "ill", "buy", "bar", "max", "doc"})));
        System.out.println(printDim(new GroupAnagrams_49().groupAnagrams(new String[]{"hos", "boo", "nay", "deb", "wow", "bop", "bob", "brr", "hey", "rye", "eve", "elf",
                "pup", "bum", "iva", "lyx", "yap", "ugh", "hem", "rod", "aha", "nam", "gap", "yea", "doc", "pen", "job", "dis", "max", "oho", "jed", "lye", "ram", "pup", "qua",
                "ugh", "mir", "nap", "deb", "hog", "let", "gym", "bye", "lon", "aft", "eel", "sol", "jab"})));
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            String hash;
            int[] hashArray = new int[26];
            for (int i = 0; i < str.length(); i++) {
                hashArray[str.charAt(i) - 'a']++;
            }
            hash = Arrays.toString(hashArray);

            List<String> anagrams = map.getOrDefault(hash, new LinkedList<>());
            anagrams.add(str);
            map.put(hash, anagrams);
        }

        return new LinkedList<>(map.values());
    }

    public static String printDim(List<List<String>> list) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            builder.append(Arrays.toString(list.get(i).toArray()));
            builder.append("\n");
        }
        return builder.toString();
    }
}
