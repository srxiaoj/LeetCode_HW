// Java program for Knight Tour problem

import java.util.Arrays;
import java.util.Scanner;
public class KnightTour {
    private static int N = 8;

    /* A utility function to check if i,j are
       valid indexes for N*N chessboard */
    private static boolean isSafe(int x, int y, int board[][]) {
        return (x >= 0 && x < N && y >= 0 &&
                y < N && board[x][y] == -1 && board[x][y] != '+');
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
        int k, nextX, nextY;
        if (moveIndex == N * N)
            return true;

        /* Try all next moves from the current coordinate
            x, y */
        int directionOfMove = 8;
        for (k = 0; k < directionOfMove; k++) {
            nextX = x + xMove[k];
            nextY = y + yMove[k];
            if (isSafe(nextX, nextY, board)) {
                board[nextX][nextY] = moveIndex;
                if (solveKTUtil(nextX, nextY, moveIndex + 1,
                        board, xMove, yMove)) {
                    return true;
                } else {
                    board[nextX][nextY] = -1;// backtracking
                }
            }
        }

        return false;
    }

    /* Driver program to test above functions */
//    public static void main(String args[]) {
//        solveKT();
//    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] fields = input.split(" ");
        // get board size
        int row = Integer.parseInt(fields[0]);
        int col = Integer.parseInt((fields[1]));
        int[][] board = new int[row][col];
        Arrays.fill(board, -1);
        // get start x, y
        input = sc.nextLine();
        fields = input.split(" ");
        int startX = Integer.parseInt(fields[0]);
        int startY = Integer.parseInt(fields[1]);
        // get target x, y
        input = sc.nextLine();
        fields = input.split(" ");
        int targetX = Integer.parseInt(fields[0]);
        int targetY = Integer.parseInt(fields[1]);
        // get blocks
        input = sc.nextLine();
        int n = Integer.parseInt(input);
        if (n != 0) ;
        int i = 0;
        while (i < n) {
            input = sc.next();
            int blockX = Integer.parseInt(fields[0]);
            int blockY = Integer.parseInt(fields[1]);
            board[blockX][blockY] = '+';
        }
    }

/*    public static int countDistance(char[][] board, int m, int n, int start_x, int start_y){
        int distance = 0;
        Deque<Integer> x = new LinkedList<>(); // store the x position of the point
        Deque<Integer> y = new LinkedList<>(); // store the y position of the point
        x.add(start_x);
        y.add(start_y);
        board[start_x][start_y] = '*';
        while(!x.isEmpty()){
            int size = x.size();
            distance++;
            for(int i = 0; i < size; i++){
                int pointX = x.remove();
                int pointY = y.remove();
                for(int j = -2; j <= 2; j = j + 4){
                    for(int k = -1; k <= 1; k = k+2){
                        if(pointX + j >= 0 && pointX + j < m && pointY + k >= 0
                                && pointY + k < n && board[pointX + j][pointY + k] != '*' && board[pointX + j][pointY + k] != '1'){
                            if(board[pointX + j][pointY + k] == 'e'){
                                return distance;
                            }
                            x.add(pointX + j);
                            y.add(pointY + k);
                            board[pointX + j][pointY + k] = '*';
                        }
                        if(pointX + k >= 0 && pointX + k < m && pointY + j >= 0
                                && pointY + j < n && board[pointX + k][pointY + j] != '*' && board[pointX + k][pointY + j] != '1'){
                            if(board[pointX + k][pointY + j] == 'e'){
                                return distance;
                            }
                            x.add(pointX + k);
                            y.add(pointY + j);
                            board[pointX + k][pointY + j] = '*';
                        }
                    }
                }
            }
        }
        return distance;

    }*/
}
// This code is contributed by Abhishek Shankhadhar