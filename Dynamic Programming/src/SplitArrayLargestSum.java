/**
 * Created by Administrator on 2016/10/19.
 */
public class SplitArrayLargestSum {
    public static void main(String[] args) {
        System.out.println(splitArray(new int[]{7, 2, 5, 10, 8}, 2));
        System.out.println(splitArray(new int[]{7, 2, 5, 10, 8}, 3));
        System.out.println(splitArray(new int[]{1, 2147483647}, 2));
        System.out.println(splitArray(new int[]{1, 4, 4}, 3));
    }

    /**
     * O(n log(sum-max))
     */
    public static int splitArray(int[] nums, int m) {
        int max = 0;
        long sum = 0;
        for (int num : nums) {
            max = Math.max(num, max);
            sum += num;
        }
        if (m == 1) return (int) sum;

        //binary search
        long l = max;
        long r = sum;
        while (l + 1 < r) {
            long mid = l + (r - l) / 2;
            if (valid(mid, nums, m)) {
                r = mid;
            } else {
                l = mid;
            }
        }
        if (valid(l, nums, m)) {
            return (int) l;
        } else {
            return (int) r;
        }
    }

    /**
     * validate whether target is a valid solution or not
     * i.e. sum of each split should be <= target and number of splits should be < m
     */
    public static boolean valid(long target, int[] nums, int m) {
        int count = 1;
        long total = 0;
        for (int num : nums) {
            total += num;
            if (total > target) {
                total = num;
                count++;
                if (count > m) {
                    return false;
                }
            }
        }
        return true;
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
