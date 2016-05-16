import java.util.Arrays;

public class WordSearch {
    private static boolean[][] visited;
    public static void main(String[] args) {
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        System.out.println(exist(board, "ABCCED"));
        System.out.println(exist(board, "SEE"));
        System.out.println(exist(board, "ABCB"));
        char[][] test = {{'a'}};
        System.out.println((exist(test, "a")));
        
    }

    /**
     * 注意当4个方向搜索完结果都为false的时候，要把visited[i][j]恢复为false
     */
    public static boolean exist(char[][] board, String word) {
        if (board == null) return false;
        int m = board.length;
        if (m == 0) return false;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(visited[i], false);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (helper(visited, board, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean helper(boolean[][] visited, char[][] board, int i, int j, String word, int pos) {
        if (pos == word.length()) return true;
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j]|| board[i][j] != word.charAt(pos)) {
            return false;
        }

        visited[i][j] = true;
        if (helper(visited, board, i + 1, j, word, pos + 1) ||
                helper(visited, board, i - 1, j, word, pos + 1) ||
                helper(visited, board, i, j + 1, word, pos + 1) ||
                helper(visited, board, i, j - 1, word, pos + 1)) {
            return true;
        }
        visited[i][j] = false;
        return false;
    }
   /* public static boolean exist(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;
        visited = new boolean[row][col];
        //initialize the visited matrix to false
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                visited[i][j] = false;
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                //search for the first letter
                if (word.charAt(0) == board[i][j] && search(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
    private static boolean search(char[][] board, String word, int i, int j, int index) {
        if (index == word.length()) return true;
        if (i >= board.length || i < 0 || j >= board[i].length ||
                j < 0 || board[i][j] != word.charAt(index) || visited[i][j])
            return false;
        //start to visit this position
        visited[i][j] = true;
        if (search(board, word, i-1, j, index+1) || search(board, word, i+1, j, index+1) ||
            search(board, word, i, j-1, index+1) || search(board, word, i, j+1, index+1)) {
            return true;
        }
        //if current position failed to convert a result, change the visit status to false
        visited[i][j] = false;
        return false;
    }*/
}