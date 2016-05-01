/**
 * Created by thanksgiving on 4/30/16.
 */
public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(fibonacci(5));
        System.out.println(fibonacci(6));
        System.out.println(fibonacci(7));
    }

    public static int fibonacci(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        // recursive
//        return fibonacci(n - 1) + fibonacci(n - 2);

        // iterative
        int[] a = new int[n + 1];
        a[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            a[i] = a[i - 1] + a[i - 2];
        }
        return a[n];
    }
}
