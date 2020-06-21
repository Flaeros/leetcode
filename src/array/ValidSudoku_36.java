package array;

public class ValidSudoku_36 {

    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'},
        };
        System.out.println(new ValidSudoku_36().isValidSudoku(board));
    }

    public boolean isValidSudoku(char[][] board) {
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (board[r][c] != '.' && !isValid(board, r, c))
                    return false;
            }
        }
        return true;
    }

    boolean isValid(char[][] board, int row, int col) {
        char num = board[row][col];
        int rowOffset = 3 * (row / 3);
        int colOffset = 3 * (col / 3);
        for (int i = 0; i < 9; i++) {
            if (i != row && board[i][col] == num) return false;
            if (i != col && board[row][i] == num) return false;
            if (rowOffset + i / 3 != row && colOffset + i % 3 != col &&
                    board[rowOffset + i / 3][colOffset + i % 3] == num)
                return false;
        }
        return true;
    }
}
