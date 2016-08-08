/**
 * Created by thanksgiving on 8/8/16.
 */
public class SudokuSolverChar {
    public static void main(String[] args) {
        SudokuSolverChar obj = new SudokuSolverChar();
        char[][] board = {
                {'.','.','9','7','4','8','.','.','.'},
                {'7','.','.','.','.','.','.','.','.'},
                {'.','2','.','1','.','9','.','.','.'},
                {'.','.','7','.','.','.','2','4','.'},
                {'.','6','4','.','1','.','5','9','.'},
                {'.','9','8','.','.','.','3','.','.'},
                {'.','.','.','8','.','3','.','2','.'},
                {'.','.','.','.','.','.','.','.','6'},
                {'.','.','.','2','7','5','9','.','.'}
        };
        obj.solveSudoku(board);
        printArray(board);
    }

    public void solveSudoku(char[][] board) {
        System.out.println(solve(board));
    }

    private boolean solve(char[][] board) {
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '.') {
                    for (char k = '1'; k <= '9'; k++) {
                        if (isSafe(board, i, j, k)) {
                            board[i][j] = k;
                            if (solve(board)) {
                                return true;
                            } else {
                                board[i][j] = '.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isSafe(char[][] board, int i, int j, char num) {
        return !isInRow(board, i, num) && !isInCol(board, j, num) && !isInBox(board, (i / 3) * 3, (j / 3) * 3, num);
    }

    private boolean isInRow(char[][] board, int row, char num) {
        for (int j = 0; j < board[0].length; j++) {
            if (board[row][j] == num) return true;
        }
        return false;
    }

    private boolean isInCol(char[][] board, int col, char num) {
        for (int i = 0; i < board.length; i++) {
            if (board[i][col] == num) return true;
        }
        return false;
    }

    private boolean isInBox(char[][] board, int rowStart, int colStart, char num) {
        for (int i = rowStart; i < rowStart + 3; i++) {
            for (int j = colStart; j < colStart + 3; j++) {
                if (board[i][j] == num) return true;
            }
        }
        return false;
    }

    /**
     * print 2D array.
     */
    public static void printArray(char[][] A) {
        for (int i = 0; i < A.length; i++) {
            System.out.print("[");
            for (int j = 0; j < A[i].length; j++) {
                if (j != A[i].length - 1) {
                    System.out.print(A[i][j] + ", ");
                } else
                    System.out.print(A[i][j]);

            }
            System.out.println("]");
        }
        System.out.println("");
    }
}
