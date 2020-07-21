package array;

public class WordSearch_79 {

    public static void main(String[] args) {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}};
        System.out.println(new WordSearch_79().exist(board, "ABCCED"));
        System.out.println(new WordSearch_79().exist(board, "SEE"));
        System.out.println(new WordSearch_79().exist(board, "ABCB"));
    }

    public boolean exist(char[][] board, String word) {

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (exist(board, i, j, word.toCharArray(), 0))
                        return true;
                }
            }
        }
        return false;
    }

    private boolean exist(char[][] board, int i, int j, char[] word, int index) {
        if (i < 0 || j < 0 || i > board.length - 1 || j > board[0].length - 1)
            return false;
        if (board[i][j] == '*')
            return false;
        if (board[i][j] != word[index])
            return false;

        if (word.length - 1 == index)
            return true;

        board[i][j] = '*';

        //search

        boolean result = exist(board, i - 1, j, word, index + 1)
                || exist(board, i, j + 1, word, index + 1)
                || exist(board, i + 1, j, word, index + 1)
                || exist(board, i, j - 1, word, index + 1);

        board[i][j] = word[index];

        return result;
    }
}
