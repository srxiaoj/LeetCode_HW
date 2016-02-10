
public class LongestIncreasingSubsequence {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] test = {10, 9, 2, 5, 3, 7, 101, 18};
        int[] test2 = {1, 3, 6, 7, 9, 4, 10, 5, 6};
        int[] test3 = {10, 9, 2, 5, 3, 4};
        int[] test4 = {2, 2};
        System.out.println(lengthOfLIS(test));
        System.out.println(lengthOfLIS(test2));
        System.out.println(lengthOfLIS(test3));
        System.out.println(lengthOfLIS(test4));
    }

    public static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 1];
        int max = 0;
        for (int i = 1; i < n + 1; i++) {
            dp[i] = 1;
            for (int j = 1; j < i; j++) {
                if (nums[i - 1] > nums[j - 1]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            max = Math.max(max, dp[i]);
        }
//        System.out.println();
        return max;

/*        if (nums.length == 0) return 0;
        int n = nums.length;
        int max = 0;
        int[] res = new int[n];

        for (int i = 0; i < n; i++) {
            res[i] = 1;
            for (int j = 0; j < i; j++) {
                // res[j] + 1 > res[i] also need to be satisfied
                if (nums[i] > nums[j] && res[j] + 1 > res[i]) {
                    res[i] = res[j] + 1;
                }
            }

            max = Math.max(max, res[i]);
        }

        return max;*/
        /*
        //failed solution
        int n = nums.length;
        if (n == 0) return 0;
        int[] res = new int[n];
        res[0] = 1;
        int max = 0;
        for (int i = 1; i < n; i++) {
            int tmp = i;
            if (nums[i - 1] < nums[i]) {
                res[i] = res[i - 1] + 1;
            } else {
                int currentNode = nums[i];
                while (i > 0 && nums[i - 1] >= currentNode) {
                    i--;
                }
                res[tmp] = res[i - 1] + 1;
            }
            i = tmp;
            max = Math.max(max, res[i]);
        }
        return max;
        */
    }
}
