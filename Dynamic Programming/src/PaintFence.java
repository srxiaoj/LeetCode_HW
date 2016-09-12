/**
 * Created by thanksgiving on 1/10/16.
 */
public class PaintFence {
    public static void main(String[] args) {
        PaintFence obj = new PaintFence();
        System.out.println(obj.numWaysDP(1, 4));
        System.out.println(obj.numWaysDP(2, 4));
        System.out.println(obj.numWaysDP(3, 4));
        System.out.println(obj.numWaysDP(4, 4));
    }
    public int numWaysDP(int n, int k) {
        if (n == 0) return 0;
        if (n == 1) return k;
        int[] same = new int[n];
        int[] diff = new int[n];

        same[1] = k;
        diff[1] = k * (k - 1);
        for (int i = 2; i < n; i++) {
            same[i] = diff[i - 1];
            diff[i] = (k - 1) * (diff[i - 1] + same[i - 1]);
        }
        printArray(same);
        printArray(diff);
        return same[n - 1] + diff[n - 1];
    }

    /**
     * 以 k = 4 为例子
     * n = 1,    same = 4                      diff = 4
     * n = 2,    same = 4 * 1                  diff = 4 * 3
     * n = 3,    same = 4 * 3 * 1              diff = (4 * 3 + 4) * 3
     * n = 4,    same = (4 * 3 + 4) * 3 * 1    diff = ((4 * 3 + 4) * 3 * 1) + 4 * 3 * 1) * 3
     */
    public int numWays(int n, int k) {
        if (n == 0) return 0;
        if (n == 1) return k;
        int fsame = k, fdiff = k * (k - 1);
        for (int i = 2; i < n; i++) {
            int tmp = fdiff;
            fdiff = (fsame + fdiff) * (k - 1);
            fsame = tmp;
        }
        return fsame + fdiff;
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
