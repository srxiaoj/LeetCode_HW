/**
 * Created by thanksgiving on 4/16/16.
 */
public class MissingNumber {
    public static void main(String[] args) {

    }


    /**
     * 算出 0 - n 个数的总和为 n * (n + 1) / 2, 那么所缺的数为这个总和减去目前数组中所有数之和
     * @param nums
     * @return
     */
    public int missingNumber(int[] nums) {
        if (nums == null) return -1;
        int n = nums.length;
        int total = (n + 1) * n / 2;
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        return total - sum;
    }
}
