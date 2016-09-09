import java.util.Arrays;

/**
 * Given an array of integers, print out the longest sequence of positive integers.
 * For example, given {-1, 2, 3, -4, 6, 12, 8, 9, -3, -5}, print out {6, 12, 8, 9}
 */
public class LongestPositiveSubsequence {
    public static void main(String[] args) {
        int[] a = {-1, 2, 3, -4, 6, 12, 8, 9, -3, -5};
        int[] res = longestPositive(a);
        printArray(res);
    }

    public static int[] longestPositive(int[] a) {
        int[] res = null;
        int start = 0;
        int len = 0, max = Integer.MIN_VALUE;
        for (int i = 0; i < a.length; i++) {
            if (a[i] <= 0) {
                len = 0;
                start = i + 1;
            } else {
                len++;
            }
            if (max < len) {
                max = len;
                res = Arrays.copyOfRange(a, start, start + len);
            }
        }
        return res;
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
