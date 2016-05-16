/**
 * Created by thanksgiving on 5/16/16.
 */
public class SurroundedRegions {
    public static void main(String[] args) {
        SurroundedRegions obj = new SurroundedRegions();
        char[][] board = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}
        };
        printArray(board);
        obj.solve(board);
        printArray(board);

    }

    /**
     * 从边界的O开始找与该 O想连的所有O，将那些O标记为*， 然后把非*改为X
     * 进行dfs(i + 1, j ,board)操作的时候要判断是不是超出边界来防止stackOverFlow
     */
    public void solve(char[][] board) {
        if (board == null || board.length == 0) return;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (i == 0 || i == board.length - 1 || j == 0 || j == board[0].length - 1) {
                    if (board[i][j] == 'O') dfs(i, j, board);
                }
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '*') board[i][j] = 'O';
                else board[i][j] = 'X';
            }
        }
        return;
    }

    private void dfs(int i, int j, char[][] board) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) return;
        if (board[i][j] == 'X' || board[i][j] == '*') return;
        board[i][j] = '*';
        if (i + 1 < board.length)
            dfs(i + 1, j, board);
        if (i - 1 > 0)
            dfs(i - 1, j, board);
        if (j + 1 < board[0].length)
            dfs(i, j + 1, board);
        if (j - 1 > 0)
            dfs(i, j - 1, board);
    }

    public static void printArray(char[][] A) {
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                if (j != A[i].length - 1) {
                    System.out.print(A[i][j] + ", ");
                } else
                    System.out.print(A[i][j]);

            }
            System.out.println("");
        }
        System.out.println("");
    }
}
