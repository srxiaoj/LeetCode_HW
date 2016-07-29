/**
 * Created by thanksgiving on 7/27/16.
 */
public class MaxValueForExpression {
    public static void main(String[] args) {
        int[] a = {3, 2, 1, 5, 2};
        System.out.println(getMax(a));
    }

    public static int getMax(int[] numbers){
        if (numbers == null || numbers.length == 0){
            return 0;
        }
        int len = numbers.length;
        int[][] dp = new int[len][len];
        for (int i = len-1; i >= 0; i--){
            for (int j = i; j < len; j++){
                if (i == j){
                    dp[i][j] = numbers[i];
                }
                else if(i + 1 == j){
                    dp[i][j] = Math.max(numbers[i] + numbers[j], numbers[i] * numbers[j]);
                }
                else {
                    //这里一个循环治好了所有毛病，从中间切，左边和右边各代表一个数字。
                    for (int k = i; k < j; k++){
                        dp[i][j] = Math.max(dp[i][j], Math.max(dp[i][k]+dp[k+1][j], dp[i][k]*dp[k+1][j]));
                    }
                }
            }
        }
        return dp[0][len-1];
    }
}
