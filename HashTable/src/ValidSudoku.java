import java.util.HashMap;

/**
 * Created by thanksgiving on 12/25/15.
 */
public class ValidSudoku {
    public static void main(String[] args) {
        ValidSudoku obj = new ValidSudoku();
        char[][] board = {
                {'.','.','.','.','5','.','.','1','.'},
                {'.','4','.','3','.','.','.','.','.'},
                {'.','.','.','.','.','3','.','.','1'},
                {'8','.','.','.','.','.','.','2','.'},
                {'.','.','2','.','7','.','.','.','.'},
                {'.','1','5','.','.','.','.','.','.'},
                {'.','.','.','.','.','2','.','.','.'},
                {'.','2','.','9','.','.','.','.','.'},
                {'.','.','4','.','.','.','.','.','.'}
        };
        System.out.println(obj.isValidSudoku(board));
    }
    public boolean isValidSudoku(char[][] board) {
        int row = board.length;
        if (row == 0) return false;
        int col = board[0].length;
        if (row % 3 != 0 || col % 3 != 0) return false;
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
        return isValid(board, 0, 3, 0, 3, row, col);
    }
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
//        HashMap<Character, Integer> colMap = new HashMap<>();
//        for (int i = colS; i < colE; i++) {
//            for (int j = rowS; j < rowE; j++) {
//                if (board[j][i] != '.' && !colMap.containsKey(board[j][i])) {
//                    colMap.put(board[j][i], 1);
//                } else if (board[j][i] != '.' && colMap.containsKey(board[j][i])) {
//                    return false;
//                }
//            }
//        }
        if (rowE < row) {
            if (!isValid(board, rowS + 3, rowE + 3, colS, colE, row, col)) {
                return false;
            }
        }
        if (colE < col) {
            if(!isValid(board, rowS, rowE, colS + 3, colE + 3, row, col)) {
                return false;
            }
        }
        return true;
    }
}
