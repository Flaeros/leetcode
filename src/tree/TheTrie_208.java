package tree;

public class TheTrie_208 {

    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.insert("apple");

        System.out.println(trie.search("apple"));   // returns true
        System.out.println(trie.search("app"));     // returns false
        System.out.println(trie.startsWith("app")); // returns true
        trie.insert("app");
        System.out.println(trie.search("app"));     // returns true
    }

    static class Trie {
        TrieNode root = new TrieNode('.');

        /**
         * Initialize your data structure here.
         */
        public Trie() {

        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            TrieNode node = root;

            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (node.nodes[c - 'a'] == null)
                    node.nodes[c - 'a'] = new TrieNode(c);
                node = node.nodes[c - 'a'];
            }
            node.isWord=true;
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            TrieNode node = root;

            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (node.nodes[c - 'a'] == null)
                    return false;
                node = node.nodes[c - 'a'];
            }
            return node.isWord;
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            TrieNode node = root;

            for (int i = 0; i < prefix.length(); i++) {
                char c = prefix.charAt(i);
                if (node.nodes[c - 'a'] == null)
                    return false;
                node = node.nodes[c - 'a'];
            }
            return true;
        }

        static class TrieNode {
            char val;
            boolean isWord = false;
            TrieNode[] nodes = new TrieNode[26];

            public TrieNode(char value) {
                val = value;
            }
        }
    }
}