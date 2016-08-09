import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueensHW {
    public static void main(String[] args) {
        NQueensHW obj = new NQueensHW();
        List<List<String>> res = obj.solveNQueens(5);
        System.out.println(res);
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        for (int i = 0; i < n; i++) {
            board[i][0] = 'Q';
            solve(res, board, 1, n);
            for (char[] sub : board) {
                Arrays.fill(sub, '.');
            }
        }
        return res;
    }

    private boolean solve(List<List<String>> res, char[][] board, int n, int num) {
        if (n == num) {
            res.add(toList(board));
            return true;
        }

        for (int i = 0; i < num; i++) {
            if (isSafe(board, i, n, num)) {
                board[i][n] = 'Q';
                if (solve(res, board, n + 1, num)) {
                    board[i][n] = '.';
                    continue;
                } else {
                    board[i][n] = '.';
                }
            }
        }
        return false;
    }

    private List<String> toList(char[][] board) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            String part = new String();
            for (int j = 0; j < board[i].length; j++) {
                part += board[i][j];
            }
            res.add(part);
        }
        return res;
    }

    private boolean isSafe(char[][] board, int i, int j, int num) {
        return !isInRow(board, i) && !isInCol(board, j) && !isInDiagonal(board, i, j, num);
    }

    private boolean isInRow(char[][] board, int row) {
        for (int j = 0; j < board[0].length; j++) {
            if (board[row][j] == 'Q') return true;
        }
        return false;
    }

    private boolean isInCol(char[][] board, int col) {
        for (int i = 0; i < board.length; i++) {
            if (board[i][col] == 'Q') return true;
        }
        return false;
    }

    private boolean isInDiagonal(char[][] board, int row, int col, int num) {
        for (int i = 0; i < row; i++) {
            if (col - row + i >= 0 && board[i][col - row + i] == 'Q') return true;
        }

        for (int i = row + 1; i < num; i++) {
            if (col + row - i >= 0 && board[i][col + row - i] == 'Q') return true;
        }
        return false;
    }
}
