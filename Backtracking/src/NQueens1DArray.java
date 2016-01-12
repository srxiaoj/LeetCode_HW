/* Java program to solve N Queen Problem using
   backtracking */
public class NQueens1DArray {
    public static void main(String[] args) {
        placeQueens(4);
    }

    private static void placeQueens(int gridSize) {
        //If Grid is 1*1 or 2*2 or 3*3 then solution is not possible as,
        //In 1*1 or 2*2 grid, Queen placed in 1st row at any position will attack queen placed at all the positions in row 2.
        //In 3*3 grid, Queen placed in 1st row and 2nd row for all combinations position will attack queen placed at all the positions in row 3.
        if (gridSize < 4) {
            System.out.println("No Solution available");
        } else {
            int[] board = new int[gridSize]; // Lets take example of 4*4
            placeQueen(board, 0);
            printBoard(board);
        }
    }

    private static boolean placeQueen(int[] board, int row) {
        if (row == board.length) {
            return true;
        }

        boolean isAllQueensPlaced = false;
        for (int column = 0; column < board.length; column++) {
            // The position of column number is stored in the board[row]
            board[row] = column;
            if (isSafe(board, row)) {
                isAllQueensPlaced = placeQueen(board, row + 1);
            }

            if (isAllQueensPlaced) {
                return true;
            }
        }
        return false;
    }


    // Return true if queen placement board[row] does not conflict with
    // other queens board[0] through board[row-1]
    private static boolean isSafe(int[] board, int row) {
        for (int i = 0; i < row; i++) {

            //Two row cannot share the same col value, which is board[i]
            if (board[row] == board[i]) {
                return false;
            }

            //Check upper left and upper right diagonal
            if (Math.abs(board[row] - board[i]) == Math.abs(row - i)) {
                return false;
            }
        }
        return true;
    }

    private static void printBoard(int[] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (j == board[i]) {
                    System.out.print("Q ");
                } else {
                    System.out.print("_ ");
                }
            }
            System.out.println();
        }
    }
}