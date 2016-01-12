
public class GameofLife {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        //block
        int[][] block = new int [4][4];
        initialize(block);
        block[1][1] = 1;
        block[1][2] = 1;
        block[2][1] = 1;
        block[2][2] = 1;
        //beehive
        int[][] beehive = new int[5][6];
        initialize(beehive);
        beehive[1][2] = 1;
        beehive[1][3] = 1;
        beehive[2][1] = 1;
        beehive[2][4] = 1;
        beehive[3][2] = 1;
        beehive[3][3] = 1;
        //blinker
        int[][] blinker = new int[5][5];
        initialize(blinker);
        blinker[2][1] = 1;
        blinker[2][2] = 1;
        blinker[2][3] = 1;
        
        printArray(beehive);
        System.out.println("Start game of life");
        gameOfLife(beehive);
        printArray(beehive);
        
    }
    public static void gameOfLife(int[][] board) {
        int row = board.length;
        int col = board[0].length;
        int[][] res = new int [row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 1) {
                    if (getNearbyLive(board, i, j) < 2) {
                        res[i][j] = 0;
                    } else if (getNearbyLive(board, i, j) == 2 || getNearbyLive(board, i, j) == 3) {
                        res[i][j] = 1;
                    } else if (getNearbyDead(board, i, j) > 3) {
                        res[i][j] = 0;
                    }
                } else {
                    if (getNearbyLive(board, i, j) == 3) {
                        res[i][j] = 1;
                    }
                }
            }
        }
        replaceArray(board, res);
    }
    /**
     * replace board with res.
     * @param board
     * @param res
     */
    private static void replaceArray(int[][] board, int[][] res) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = res[i][j];
            }
        }
    }
    /**
     * get nearby live cell number.
     * @param board 
     * @param x current x index
     * @param y current y index
     * @return
     */
    private static int getNearbyLive(int[][] board, int x, int y) {
        int count = 0;
        for (int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + 1; j++) {
                if (i >= 0 && i < board.length && j >= 0
                        && j < board[i].length && board[i][j] == 1) {
                    count++;
                }
            }
        }
        if (board[x][y] == 1) count--;
        //System.out.println(x + ", " + y + " has " + count + " nearby live");
        return count;
    }
    /**
     * get nearby dead cell number.
     * @param board
     * @param x current x index
     * @param y current y index
     * @return
     */
    private static int getNearbyDead(int[][] board, int x, int y) {
        int count = 0;
        for (int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + 1; j++) {
                if (i >= 0 && i < board.length && j >= 0
                        && j < board[i].length && board[i][j] == 0) {
                    count++;
                }
            }
        }
        if (board[x][y] == 0) count--;
        //System.out.println(x + ", " + y + " has " + count + " nearby dead");
        return count;
    }
    /**
     * print 2D array.
     * @param A array
     */
    public static void printArray(int[][] A)
    {
        for(int i = 0; i < A.length; i++)
        {
            for (int j = 0; j < A[i].length; j++) {
                if(j != A[i].length-1)
                    System.out.print(A[i][j] + ", ");
                else
                    System.out.print(A[i][j]);
            }
            System.out.println("");
        }
        System.out.println("");
    }
    /**
     * initialize the board with 0.
     * @param board array
     */
    private static void initialize(int[][] board) {
        for (int i = 0; i < board.length; i ++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = 0;
            }
        }
    }
}
