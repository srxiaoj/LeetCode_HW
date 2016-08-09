import java.util.ArrayList;
import java.util.List;

public class NQueensAllSolutions {
    public static void main(String[] args) {
        NQueensAllSolutions queen = new NQueensAllSolutions();
        List<String[]> res = queen.solveNQueens(5);
        for (int i = 0; i < res.size(); i++) {
            printArray(res.get(i));
        }
    }

    public List<String[]> solveNQueens(int n) {
        int count = 0;
        List<String[]> res = new ArrayList<>();
        // i represents row number
        // board[i] represent for the column number for ith queen
        int[] board = new int[n + 1];
        int row = 1; //queen 1 start at row 1
        while (row > 0) {
            board[row]++;//put down the queen on next col
            while (board[row] <= n && !isSafe(row, board)) board[row]++;
            if (board[row] <= n) {
                if (row == n) { // already put all the queens
                    res.add(toString(board));
                    count++;
                } else
                    row++; // continue to put next queen
            } else {// no place to put queen
                board[row] = 0;
                row--;
            }
        }
        System.out.println("count is:" + count);
        return res;
    }

    /**
     * check whether the queen can be put in this row
     */
    public static boolean isSafe(int aRow, int[] board) {
        for (int i = 1; i < aRow; i++) {
            //on the diagonal or on the same column
            if (Math.abs(board[aRow] - board[i]) == Math.abs(aRow - i) || board[aRow] == board[i])
                return false;
        }
        return true;
    }

    /**
     * save the solution to string []
     */
    //print array
    public static void printArray(String[] A) {
        System.out.println("Solution: ");
        for (int i = 0; i < A.length; i++) {
            System.out.println(A[i] + " ");
        }
        System.out.println(" ");
    }

    public static String[] toString(int[] y) {
        //create a stringbuilder [] to store the result
        StringBuilder[] res = new StringBuilder[y.length - 1];
        String[] resString = new String[y.length - 1];
        for (int i = 0; i < y.length - 1; i++) {
            res[i] = new StringBuilder(".");
            for (int j = 1; j < y.length - 1; j++) {
                res[i].append(".");
            }
        }
        for (int i = 1; i < y.length; i++) {
            for (int j = 1; j < y.length; j++) {
                if (j == y[i])
                    res[i - 1].setCharAt(j - 1, 'Q');
            }
            resString[i - 1] = res[i - 1].toString();
        }
        //printArray(resString);
        return resString;
    }

    /**
     * print out solution method
     */
//    public static void print(int[] y){
//        System.out.println("result: ");
//        for(int i = 1; i < y.length; i++){
//            for(int j = 1; j < y.length; j++){
//                if(j == y[i])
//                    System.out.print("*");
//                else
//                    System.out.print("o");
//            }
//            System.out.println("");
//        }
//    }
}
