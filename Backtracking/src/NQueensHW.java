import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueensHW {
    public static void main(String[] args) {
        NQueensHW obj = new NQueensHW();
        List<List<String>> res = obj.solveNQueens(8);
        System.out.println(res);
        System.out.println(res.size());
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] part = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(part[i], '.');
        }
//        solve(res, part, 0, n);
        helper(res, part, 0, n);
        return res;
    }

    /**
     * 返回true 或者 void 方法效果一样
     */
    private void helper(List<List<String>> res, char[][] part, int pos, int n) {
        if (pos == n) {
            res.add(toList(part));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (isSafe(part, i, pos, n)) {
                part[i][pos] = 'Q';
                helper(res, part, pos + 1, n);
                part[i][pos] = '.';
            }
        }
    }

    private boolean solve(List<List<String>> res, char[][] part, int pos, int n) {
        if (n == pos) {
            res.add(toList(part));
            return true;
        }
        for (int i = 0; i < n; i++) {
            if (isSafe(part, i, pos, n)) {
                part[i][pos] = 'Q';
                if (solve(res, part, pos + 1, n)) {
                    part[i][pos] = '.';
                    continue;
                } else {
                    part[i][pos] = '.';
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
