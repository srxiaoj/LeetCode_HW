/**
 * Write a function to figure out whether there is a winner on a Tic-Tac-Toe board configuration
 */
public class HasTicTacToeSolution {
    public static void main(String[] args) {
        char[][] grid = new char[][]{
                {'X', 'O', 'X'},
                {'O', 'X', 'O'},
                {'X', ' ', 'O'}
        };
        System.out.println(hasSolution(grid));
    }

    public static boolean hasSolution(char[][] grid) {
        // check all rows
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            if (grid[i][0] == grid[i][1] && grid[i][1] == grid[i][2]) {
                return true;
            }
        }

        for (int i = 0; i < n; i++) {
            if (grid[0][i] == grid[1][i] && grid[1][i] == grid[2][i]) {
                return true;
            }
        }

        if (grid[0][0] == grid[1][1] && grid[1][1] == grid[2][2]) {
            return true;
        }

        if (grid[0][2] == grid[1][1] && grid[2][0] == grid[1][1]) {
            return true;
        }

        return false;
    }
}
