package array;

import java.util.Arrays;

public class SurroundedRegions {

    public static void main(String[] args) {
        char[][] a = new char[][]{
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}};
        new SurroundedRegions().solve(a);
        System.out.println(printDim(a));

        a = new char[][]{
                {'X', 'O', 'X', 'O', 'X', 'O'},
                {'O', 'X', 'O', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'O', 'X', 'O'},
                {'O', 'X', 'O', 'X', 'O', 'X'}};
        new SurroundedRegions().solve(a);
        System.out.println(printDim(a));

        a = new char[][]{
                {'O', 'O', 'O', 'O', 'X', 'X'},
                {'O', 'O', 'O', 'O', 'O', 'O'},
                {'O', 'X', 'O', 'X', 'O', 'O'},
                {'O', 'X', 'O', 'O', 'X', 'O'},
                {'O', 'X', 'O', 'X', 'O', 'O'},
                {'O', 'X', 'O', 'O', 'O', 'O'}};
        new SurroundedRegions().solve(a);
        System.out.println(printDim(a));
    }

    public void solve(char[][] board) {
        int r = board.length;
        if (r == 0) {
            return;
        }
        int c = board[0].length;

        for (int i = 0; i < r; i++) {
            if (board[i][0] == 'O')
                flip(board, i, 0);
            if (board[i][c - 1] == 'O')
                flip(board, i, c - 1);
        }

        for (int j = 0; j < c; j++) {
            if (board[0][j] == 'O')
                flip(board, 0, j);
            if (board[r - 1][j] == 'O')
                flip(board, r - 1, j);
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (board[i][j] == 'O')
                    board[i][j] = 'X';
                if (board[i][j] == '*')
                    board[i][j] = 'O';
            }
        }
    }

    private void flip(char[][] board, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != 'O') {
            return;
        }
        board[i][j] = '*';
        flip(board, i - 1, j);
        flip(board, i, j + 1);
        flip(board, i + 1, j);
        flip(board, i, j - 1);
    }

    public static String printDim(char[][] mx) {
        StringBuilder builder = new StringBuilder();
        for (char[] chars : mx) {
            builder.append(Arrays.toString(chars));
            builder.append("\n");
        }
        return builder.toString();
    }
}
