import java.util.Arrays;

/**
 * Created by thanksgiving on 9/5/16.
 */
public class IsSubsequence {
    public static void main(String[] args) {
        System.out.println(isSubsequence("abc", "ahbgdc"));
        System.out.println(isSubsequence("axc", "ahbgdc"));
    }

    public static boolean isSubsequence(String s, String t) {
        if (s.length() == 0) return true;
        int m = s.length(), n = t.length();

        int[] match = new int[m];
        Arrays.fill(match, -1);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (s.charAt(i) == t.charAt(j) && (i == 0 || (j > match[i - 1] && match[i - 1] != -1))) {
                    match[i] = j;
                    break;
                }
            }
            printArray(match);
        }
        if (match[m - 1] != -1) return true;
        return false;
    }

    /**
     * print 2D array.
     */
    public static void printArray(boolean[][] A) {
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

    //print array
    public static void printArray(int[] A) {
        System.out.print("[");
        for (int i = 0; i < A.length; i++) {
            if (i != A.length - 1)
                System.out.print(A[i] + ", ");
            else
                System.out.print(A[i]);
        }
        System.out.println("]");
    }
}
