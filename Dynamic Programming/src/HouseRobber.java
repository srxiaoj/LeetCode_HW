import java.util.Arrays;


public class HouseRobber {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] test =   {3, 5, 1, 6, 9, 1};
        System.out.println(rob(test));
    }
    public static int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int[] robbedValue = new int[n + 1];
        Arrays.fill(robbedValue, Integer.MIN_VALUE);
        robbedValue[0] = 0;
        robbedValue[1] = nums[0];
        for (int i = 2; i <= n; i++) {           
            robbedValue[i] = Math.max(robbedValue[i-1], robbedValue[i-2] + nums[i-1]);
        }
        return robbedValue[n];
    }

}
