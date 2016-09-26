/**
 * Created by thanksgiving on 9/26/16.
 */
public class MonkeyJump {
    public static void main(String[] args) {
        System.out.println(monkeyJump(new int[]{1, -1, 0, 2, 3, 5}, 3));
        System.out.println(monkeyJump(new int[]{-1, -1, -1, -1}, 3));
        System.out.println(monkeyJump(new int[]{1, 2, 3}, 2));
        System.out.println(monkeyJump(new int[]{1, 2, 3}, 4));
        System.out.println(monkeyJump(new int[]{6, 5, 4, 3, 2, 1, -1}, 3));
        System.out.println(monkeyJump(new int[]{2, 1, -1, 0}, 2));
        System.out.println(monkeyJump(new int[]{0, -1, 2}, 1));
        System.out.println(monkeyJump(new int[]{0, -1, 2}, 2));
    }

    public static int monkeyJump(int[] A, int D) {
        if (A == null || A.length == 0) return -1;
        if (D > A.length) return 0;
        int[] dp = new int[A.length + 1];
        for (int i = 0; i < D; i++) {
            dp[i] = A[i];
        }
        for (int i = D; i < A.length; i++) {
            if (A[i] == -1) {
                dp[i] = -1;
            } else {
                int temp = Integer.MAX_VALUE;
                int count = 0;
                for (int j = 1; j <= D; j++) {
                    if (dp[i - j] == -1) {
                        count++;
                        continue;
                    }
                    temp = Math.min(temp, dp[i - j]);
                }
                dp[i] = (count == D) ? -1 : Math.max(temp, A[i]);
            }
        }
        int res = Integer.MAX_VALUE;
        int count = 0;
        for (int j = 1; j <= D; j++) {
            if (dp[A.length - j] == -1) {
                count++;
                continue;
            }
            res = Math.min(res, dp[A.length - j]);
        }
        return (count == D) ? -1 : res;
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
