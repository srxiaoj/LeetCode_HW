// Java program for Knight Tour problem
public class KnightTour {
    private static int N = 8;

    /* A utility function to check if i,j are
       valid indexes for N*N chessboard */
    private static boolean isSafe(int x, int y, int board[][]) {
        return (x >= 0 && x < N && y >= 0 &&
                y < N && board[x][y] == -1);
    }

    /* A utility function to print solution
       matrix sol[N][N] */
    private static void printSolution(int board[][]) {
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++)
                System.out.print(board[x][y] + " ");
            System.out.println();
        }
    }

    /* This function solves the Knight Tour problem
       using Backtracking.  This  function mainly
       uses solveKTUtil() to solve the problem. It
       returns false if no complete tour is possible,
       otherwise return true and prints the tour.
       Please note that there may be more than one
       solutions, this function prints one of the
       feasible solutions.  */
    public static boolean solveKT() {
        int board[][] = new int[8][8];

        /* Initialization of solution matrix */
        for (int x = 0; x < N; x++)
            for (int y = 0; y < N; y++)
                board[x][y] = -1;

       /* xMove[] and yMove[] define next move of Knight.
          xMove[] is for next value of x coordinate
          yMove[] is for next value of y coordinate */
        int xMove[] = {2, 1, -1, -2, -2, -1,  1,  2};
        int yMove[] = {1, 2,  2,  1, -1, -2, -2, -1};

        // Since the Knight is initially at the first block
        board[0][0] = 0;

        /* Start from 0,0 and explore all tours using
           solveKTUtil() */
        if (!solveKTUtil(0, 0, 1, board, xMove, yMove)) {
            System.out.println("Solution does not exist");
            return false;
        } else
            printSolution(board);

        return true;
    }

    /* A recursive utility function to solve Knight
       Tour problem */
    private static boolean solveKTUtil(int x, int y, int moveIndex,
                               int board[][], int xMove[],
                               int yMove[]) {
        int k, next_x, next_y;
        if (moveIndex == N * N)
            return true;

        /* Try all next moves from the current coordinate
            x, y */
        int directionOfMove = 8;
        for (k = 0; k < directionOfMove; k++) {
            next_x = x + xMove[k];
            next_y = y + yMove[k];
            if (isSafe(next_x, next_y, board)) {
                board[next_x][next_y] = moveIndex;
                if (solveKTUtil(next_x, next_y, moveIndex + 1,
                        board, xMove, yMove)) {
                    return true;
                } else {
                    board[next_x][next_y] = -1;// backtracking
                }
            }
        }

        return false;
    }

    /* Driver program to test above functions */
    public static void main(String args[]) {
        solveKT();
    }
}
// This code is contributed by Abhishek Shankhadhar