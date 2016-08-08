/**
 * Created by thanksgiving on 12/25/15.
 */
public class SudokuSolver {
    private static final int N = 9;

    public static void main(String[] args) {
        // 0 means unassigned cells
        SudokuSolver obj = new SudokuSolver();
        int[][] grid = {
                {3, 0, 6, 5, 0, 8, 4, 0, 0},
                {5, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 8, 7, 0, 0, 0, 0, 3, 1},
                {0, 0, 3, 0, 1, 0, 0, 8, 0},
                {9, 0, 0, 8, 6, 3, 0, 0, 5},
                {0, 5, 0, 0, 9, 0, 6, 0, 0},
                {1, 3, 0, 0, 0, 0, 2, 5, 0},
                {0, 0, 0, 0, 0, 0, 0, 7, 4},
                {0, 0, 5, 2, 0, 6, 3, 0, 0}};
        if (obj.solveSudoku(grid))
            printArray(grid);
        else
            System.out.println("No solution exists");
    }

    public boolean solveSudoku(int[][] grid) {
        return solve(grid);
    }

    public boolean solve(int[][] grid) {
//        if (!FindUnassignedLocation(grid)) return true;
        int row = grid.length;
        int col = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 0) {
                    for (int val = 1; val <= 9; val++) {
                        if (isSafe(grid, i, j, val)) {
                            grid[i][j] = val;
                            if (solve(grid)) {
                                return true;
                            } else {
                                grid[i][j] = 0;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean FindUnassignedLocation(int[][] grid) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == 0)
                    return true;
            }
        }
        return false;
    }

    /* Returns a boolean which indicates whether any assigned entry
       in the specified row matches the given number. */
    private boolean UsedInRow(int[][] grid, int row, int num) {
        for (int col = 0; col < N; col++)
            if (grid[row][col] == num)
                return true;
        return false;
    }

    /* Returns a boolean which indicates whether any assigned entry
       in the specified column matches the given number. */
    private boolean UsedInCol(int[][] grid, int col, int num) {
        for (int row = 0; row < N; row++)
            if (grid[row][col] == num)
                return true;
        return false;
    }

    /* Returns a boolean which indicates whether any assigned entry
       within the specified 3x3 box matches the given number. */
    private boolean UsedInBox(int[][] grid, int boxStartRow, int boxStartCol, int num) {
        for (int row = 0; row < 3; row++)
            for (int col = 0; col < 3; col++)
                if (grid[row + boxStartRow][col + boxStartCol] == num)
                    return true;
        return false;
    }

    /* Returns a boolean which indicates whether it will be legal to assign
       num to the given row,col location. */
    private boolean isSafe(int[][] grid, int row, int col, int num) {
    /* Check if 'num' is not already placed in current row,
       current column and current 3x3 box */
        return !UsedInRow(grid, row, num) &&
                !UsedInCol(grid, col, num) &&
                !UsedInBox(grid, row - row % 3, col - col % 3, num);
    }

    /**
     * print 2D array.
     */
    public static void printArray(int[][] A) {
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                if (j != A[i].length - 1)
                    System.out.print(A[i][j] + ", ");
                else
                    System.out.print(A[i][j]);
            }
            System.out.println("");
        }
        System.out.println("");
    }
}
