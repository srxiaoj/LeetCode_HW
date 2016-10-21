/**
 * Created by Administrator on 2016/10/19.
 */
public class SplitArrayLargestSum {
    public static void main(String[] args) {
        System.out.println(splitArray(new int[]{7, 2, 5, 10, 8}, 2));
        System.out.println(splitArray(new int[]{7, 2, 5, 10, 8}, 3));
    }

    public static int splitArray(int[] nums, int m) {
        int count = m - 1, used = 0;
        int max = nums[0];
        int n = nums.length;
        int[] sum = new int[n];
        sum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            sum[i] = sum[i - 1] + nums[i];
        }

        int i = 1;
        while (i < n - 1 && count > 0) {
            int restAverage = (sum[n - 1] - sum[i - 1]) / count;
            if (restAverage > sum[i] && (sum[n - 1] - sum[i]) / count < sum[i + 1]) {
                i++;
            } else {
                max = Math.max(max, sum[i] - used);
                used = sum[i];
                i++;
                count--;
            }
        }
//        max = Math.max(max, sum[n - 1] - used);
        return max;
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
