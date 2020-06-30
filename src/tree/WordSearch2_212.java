package tree;

import java.util.ArrayList;
import java.util.List;

public class WordSearch2_212 {

    public static void main(String[] args) {
        System.out.println(new WordSearch2_212().findWords(new char[][]{
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}
        }, new String[]{"oath", "pea", "eat", "rain"}));
    }


    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        TrieNode trieNode = buildTrie(words);

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, trieNode, result);
            }
        }
        return result;
    }

    private void dfs(char[][] board, int i, int j, TrieNode node, List<String> res) {
        char c = board[i][j];
        if (c == '*' || node.next[c - 'a'] == null)
            return;

        node = node.next[c - 'a'];
        if (node.word != null) {
            res.add(node.word);
            node.word = null;
        }

        board[i][j] = '*';

        if (i > 0) dfs(board, i - 1, j, node, res);
        if (j > 0) dfs(board, i, j - 1, node, res);
        if (i < board.length - 1) dfs(board, i + 1, j, node, res);
        if (j < board[0].length - 1) dfs(board, i, j + 1, node, res);

        board[i][j] = c;
    }


    public TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String w : words) {
            TrieNode p = root;
            for (char c : w.toCharArray()) {
                int i = c - 'a';
                if (p.next[i] == null) p.next[i] = new TrieNode();
                p = p.next[i];
            }
            p.word = w;
        }
        return root;
    }

    class TrieNode {
        TrieNode[] next = new TrieNode[26];
        String word;
    }
}
