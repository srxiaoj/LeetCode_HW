/**
 * Created by Administrator on 2016/10/10.
 */
public class ArithmeticSequence {
    public static void main(String[] args) {
        System.out.println(getLAS(new int[] {1, 3, 5, 2, 7, 6, 8, 10, 12}));
    }

    public static int getLAS(int[] A) {
        // Time: O(n)
        // Space: O(1)
        if (A.length < 3) return 0;

        int res = 0;
        int diff = Integer.MIN_VALUE;
        int count = 0;
        int start = 0;
        for (int i = 1; i < A.length; i++) {
            int curDiff = A[i] - A[i - 1];
            if (diff == curDiff) {
                count += i - start - 1 > 0 ? i - start - 1 : 0;
            } else {
                start = i - 1;
                diff = curDiff;
                res += count;
                count = 0;
            }
        }
        res += count;
        return res;
    }
}
