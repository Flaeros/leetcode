package array;

import static array.SurroundedRegions.printDim;

public class SudokuSolver_37 {

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
        new SudokuSolver_37().solveSudoku(board);
        System.out.println(printDim(board));
    }

    public void solveSudoku(char[][] board) {
        solve(board, 0, 0);
    }

    public boolean solve(char[][] board, int r, int c) {
        for (int i = r; i < 9; i++) {
            for (int j = c; j < 9; j++) {
                if (board[i][j] != '.')
                    continue;

                for (char num = '1'; num <= '9'; num++) {
                    if (isValid(board, i, j, num)) {
                        board[i][j] = num;
                        if (solve(board, i, j))
                            return true;
                        board[i][j] = '.';
                    }
                }
                return false;
            }
            c = 0;
        }
        return true;
    }

    public boolean isValid(char[][] board, int row, int col, int val) {
        int rowOffset = 3 * (row / 3);
        int colOffset = 3 * (col / 3);

        for (int i = 0; i < 9; i++) {
            if (board[i][col] == val) return false;
            if (board[row][i] == val) return false;
            if (board[rowOffset + i / 3][colOffset + i % 3] == val)
                return false;
        }
        return true;
    }
}
