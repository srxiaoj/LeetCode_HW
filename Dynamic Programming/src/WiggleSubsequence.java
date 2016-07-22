/**
 * Created by thanksgiving on 7/21/16.
 */
public class WiggleSubsequence {
    public static void main(String[] args) {
        int[] a = {1,17,5,10,13,15,10,5,16,8};
        System.out.println(wiggleMaxLength(a));
    }

    // up[i] 表示以i点作为上升结束点所能达到的最大长度
    public static int wiggleMaxLength(int[] a) {
        if (a == null || a.length == 0) return 0;
        int n = a.length;
        int[] up = new int[n];
        int[] down = new int[n];
        up[0] = 1;
        down[0] = 1;
        for (int i = 1; i < n; i++) {
            if (a[i] > a[i - 1]) {
                up[i] = down[i - 1] + 1;
                down[i] = down[i - 1];
            } else if (a[i] < a[i - 1]) {
                down[i] = up[i - 1] + 1;
                up[i] = up[i - 1];
            } else {
                down[i] = down[i - 1];
                up[i] = up[i - 1];
            }
        }
        return Math.max(up[n - 1], down[n - 1]);
    }
}
