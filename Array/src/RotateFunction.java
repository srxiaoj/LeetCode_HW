/**
 * Created by thanksgiving on 9/16/16.
 */
public class RotateFunction {
    public static void main(String[] args) {
        System.out.println(maxRotateFunction(new int[] {4, 3, 2, 6}));
        System.out.println(maxRotateFunction(new int[] {-2147483648, -2147483648}));
    }

    /**
     * f[] can be reduced to f
     */
    public static int maxRotateFunction(int[] A) {
        if (A == null || A.length == 0) return 0;
        int n = A.length;

        long max = Long.MIN_VALUE;
        long [] f = new long[n];
        long sum = 0;
        for (int i = 0; i < n; i++) {
            f[0] += i * A[i];
            sum += A[i];
        }
        max = Math.max(f[0], max);

        for (int i = 1; i < n; i++) {
            f[i] = f[i - 1] + sum - n * A[n - i];
            max = Math.max(f[i], max);
        }
        if (max <= Integer.MIN_VALUE) max = Integer.MIN_VALUE;
        if (max >= Integer.MAX_VALUE) max = Integer.MAX_VALUE;
        printArray(f);
        return (int) max;
    }


    //print array
    public static void printArray(long[] A) {
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
