/**
 * Created by thanksgiving on 1/10/16.
 */
public class PaintFence {
    public static void main(String[] args) {
        PaintFence obj = new PaintFence();
        System.out.println(obj.numWays(3, 3));
    }
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
}
