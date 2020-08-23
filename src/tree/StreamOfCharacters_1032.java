package tree;

public class StreamOfCharacters_1032 {

    public static void main(String[] args) {
        StreamChecker streamChecker = new StreamChecker(new String[]{"cd", "f", "kl"}); // init the dictionary.
        System.out.println(streamChecker.query('a'));          // return false
        System.out.println(streamChecker.query('b'));          // return false
        System.out.println(streamChecker.query('c'));          // return false
        System.out.println(streamChecker.query('d'));          // return true, because 'cd' is in the wordlist
        System.out.println(streamChecker.query('e'));          // return false
        System.out.println(streamChecker.query('f'));          // return true, because 'f' is in the wordlist
        System.out.println(streamChecker.query('g'));          // return false
        System.out.println(streamChecker.query('h'));          // return false
        System.out.println(streamChecker.query('i'));          // return false
        System.out.println(streamChecker.query('j'));          // return false
        System.out.println(streamChecker.query('k'));          // return false
        System.out.println(streamChecker.query('l'));          // return true, because 'kl' is in the wordlist
    }

    static class StreamChecker {

        TrieNode root = new TrieNode();
        StringBuilder sb = new StringBuilder();

        public StreamChecker(String[] words) {
            createTrie(words);
        }

        private void createTrie(String[] words) {
            for (String word : words) {
                TrieNode node = root;
                int len = word.length();

                for (int i = len - 1; i >= 0; i--) {
                    char c = word.charAt(i);
                    if (node.next[c - 'a'] == null) {
                        node.next[c - 'a'] = new TrieNode();
                    }
                    node = node.next[c - 'a'];
                }
                node.isWord = true;
            }
        }

        public boolean query(char letter) {
            sb.append(letter);
            TrieNode node = root;
            for (int i = sb.length() - 1; i >= 0 && node != null; i--) {
                char c = sb.charAt(i);
                node = node.next[c - 'a'];
                if (node != null && node.isWord) {
                    return true;
                }

            }
            return false;
        }

        class TrieNode {
            boolean isWord;
            TrieNode[] next = new TrieNode[26];
        }
    }
}
