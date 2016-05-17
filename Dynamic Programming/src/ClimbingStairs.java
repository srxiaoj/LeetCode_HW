/**
 * Created by thanksgiving on 2/11/16.
 */
public class ClimbingStairs {
    public static void main(String[] args) {
        ClimbingStairs obj = new ClimbingStairs();

        System.out.println(obj.climbStairs(2));
        System.out.println(obj.climbStairs(3));
        System.out.println(obj.climbStairs(4));
        System.out.println(obj.climbStairs(5));
        System.out.println(obj.climbStairs(6));
    }

    public int climbStairs(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;
        int[] res = new int[n + 1];
        res[0] = 1;
        res[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            res[i] = res[i - 1] + res[i - 2];
        }
        return res[n];
    }
}
