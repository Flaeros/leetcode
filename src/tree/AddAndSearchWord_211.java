package tree;

public class AddAndSearchWord_211 {

    public static void main(String[] args) {

        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");

        System.out.println(wordDictionary.search("pad")); //-> false
        System.out.println(wordDictionary.search("bad")); //-> true
        System.out.println(wordDictionary.search(".ad")); //-> true
        System.out.println(wordDictionary.search("b..")); //-> true


        wordDictionary = new WordDictionary();
        wordDictionary.addWord("at");
        wordDictionary.addWord("and");
        wordDictionary.addWord("an");
        wordDictionary.addWord("add");
        wordDictionary.search("a");
    }

    public static class WordDictionary {

        TrieNode root;

        /**
         * Initialize your data structure here.
         */
        public WordDictionary() {
            root = new TrieNode();
        }

        /**
         * Adds a word into the data structure.
         */
        public void addWord(String word) {
            TrieNode node = root;

            if (word == null || word.length() < 1)
                return;

            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                int pos = c - 'a';
                if (node.next[pos] == null) {
                    node.next[pos] = new TrieNode();
                }
                node = node.next[pos];
            }
            node.word = word;
        }

        /**
         * Returns if the word is in the data structure.
         * A word could contain the dot character '.' to represent any one letter.
         */
        public boolean search(String word) {
            if (word == null || word.length() < 1)
                return false;
            return search(root, word, 0);
        }

        private boolean search(TrieNode node, String word, int index) {
            if (word.length() == index && node.word != null)
                return true;

            if(word.length() == index && node.word == null)
                return false;

            char c = word.charAt(index);
            int pos = c - 'a';
            boolean anyChar = c == '.';

            if (anyChar) {
                if (node.next == null || node.next.length == 0)
                    return false;
                for (TrieNode trieNode : node.next) {
                    if (trieNode != null && search(trieNode, word, index + 1))
                        return true;
                }
                return false;
            } else {
                if (node.next[pos] == null) {
                    return false;
                } else {
                    return search(node.next[pos], word, index + 1);
                }
            }
        }

        public static class TrieNode {
            TrieNode[] next = new TrieNode[26];
            String word;
        }
    }
}
