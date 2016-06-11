import java.util.HashMap;
import java.util.Map;

/**
 * Created by thanksgiving on 12/25/15.
 */
public class ValidSudoku {
    public static void main(String[] args) {
        ValidSudoku obj = new ValidSudoku();
        char[][] board = {
                {'.', '.', '.', '.', '5', '.', '.', '1', '.'},
                {'.', '4', '.', '3', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '3', '.', '.', '1'},
                {'8', '.', '.', '.', '.', '.', '.', '2', '.'},
                {'.', '.', '2', '.', '7', '.', '.', '.', '.'},
                {'.', '1', '5', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '2', '.', '.', '.'},
                {'.', '2', '.', '9', '.', '.', '.', '.', '.'},
                {'.', '.', '4', '.', '.', '.', '.', '.', '.'}
        };
        System.out.println(obj.isValidSudoku(board));
    }

    /**
     * solution 2:
     */
    public boolean isValidSudoku2(char[][] board) {
        //first dimension 0/horizontal 1/vertical 2/square
        //second dimension 0-8 represents the ith row/column/square
        //third dimension represents the occurrence of number 1-9
        boolean[][][] occur = new boolean[3][9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') continue;
                int num = board[i][j] - '1';
                if (occur[0][i][num]) {
                    return false;
                } else {
                    occur[0][i][num] = true;
                }
                if (occur[1][j][num]) {
                    return false;
                } else {
                    occur[1][j][num] = true;
                }
                int s = (i / 3) * 3 + j / 3;
                if (occur[2][s][num]) {
                    return false;
                } else {
                    occur[2][s][num] = true;
                }
            }
        }
        return true;
    }


    /**
     * solution 1:
     * 1. 检查所有row
     * 2. 检查所有col
     * 3. dfs检查所有sub matrix
     */
    public boolean isValidSudoku(char[][] board) {
        int row = board.length;
        if (row == 0) return false;
        int col = board[0].length;
        if (row % 3 != 0 || col % 3 != 0) return false;
        // each row doesn't contain duplicates
        for (int i = 0; i < row; i++) {
            HashMap<Character, Integer> rowMap = new HashMap<>();
            for (int j = 0; j < col; j++) {
                if (board[i][j] != '.' && !rowMap.containsKey(board[i][j])) {
                    rowMap.put(board[i][j], 1);
                } else if (board[i][j] != '.' && rowMap.containsKey(board[i][j])) {
                    return false;
                }
            }
        }
        // each column doesn't contain duplicates
        for (int i = 0; i < col; i++) {
            HashMap<Character, Integer> colMap = new HashMap<>();
            for (int j = 0; j < row; j++) {
                if (board[j][i] != '.' && !colMap.containsKey(board[j][i])) {
                    colMap.put(board[j][i], 1);
                } else if (board[j][i] != '.' && colMap.containsKey(board[j][i])) {
                    return false;
                }
            }
        }
        // each sub matrix doesn't contain duplicates
        return helper(board, 0, 0);
//        return isValid(board, 0, 3, 0, 3, row, col);
    }

    // 方法2
    private boolean helper(char[][] grid, int m, int n) {
        if (m == grid.length || n == grid[0].length) return true;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = m; i < m + 3; i++) {
            for (int j = n; j < n + 3; j++) {
                int key = grid[i][j] - '0';
                if (map.containsKey(key) && grid[i][j] != '.') {
                    return false;
                } else if (grid[i][j] != '.' && !map.containsKey(key)) {
                    map.put(key, 1);
                }
            }
        }
        return helper(grid, m + 3, n) && helper(grid, m, n + 3);
    }

    // 方法3
    public boolean isValid(char[][] board, int rowS, int rowE, int colS, int colE, int row, int col) {
        HashMap<Character, Integer> rowMap = new HashMap<>();
        for (int i = rowS; i < rowE; i++) {
            for (int j = colS; j < colE; j++) {
                if (board[i][j] != '.' && !rowMap.containsKey(board[i][j])) {
                    rowMap.put(board[i][j], 1);
                } else if (board[i][j] != '.' && rowMap.containsKey(board[i][j])) {
                    return false;
                }
            }
        }

        if (rowE < row) {
            if (!isValid(board, rowS + 3, rowE + 3, colS, colE, row, col)) {
                return false;
            }
        }
        if (colE < col) {
            if (!isValid(board, rowS, rowE, colS + 3, colE + 3, row, col)) {
                return false;
            }
        }
        return true;
    }
}
