package tree;

import java.util.*;

import static java.util.Arrays.asList;

public class WordBreak2_140 {

    public static void main(String[] args) {
        System.out.println(new WordBreak2_140().wordBreak("catsanddog", asList("cat", "cats", "and", "sand", "dog")));
        System.out.println(new WordBreak2_140().wordBreak("pineapplepenapple", asList("apple", "pen", "applepen", "pine", "pineapple")));
        System.out.println(new WordBreak2_140().wordBreak("catsandog", asList("cats", "dog", "sand", "and", "cat")));
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        return search(s, new HashSet<>(wordDict), new HashMap<>());
    }

    public List<String> search(String subWord, Set<String> words, Map<String, List<String>> memo) {
        if(memo.containsKey(subWord))
            return memo.get(subWord);

        List<String> result = new LinkedList<>();

        if(subWord.length() == 0) {
            result.add("");
            return result;
        }

        for (String word : words) {
            if(subWord.startsWith(word)) {
                List<String> subResult = search(subWord.substring(word.length()), words, memo);
                for (String res : subResult) {
                    result.add(word + (res.isEmpty() ? "" : " ") + res);
                }
            }
        }

        memo.put(subWord, result);
        return result;
    }

}
