import java.util.TreeSet;

/**
 * Created by thanksgiving on 9/4/16.
 */
public class MaxSumofArrayNoLargerThanK {
    public static void main(String[] args) {
        MaxSumofArrayNoLargerThanK obj = new MaxSumofArrayNoLargerThanK();
//        System.out.println(obj.maxSum(new int[] {1, 3, -1, 0, 2}, -1));
//        System.out.println(obj.maxSum(new int[] {1, 3, -1, 0, 2}, 5));
//        System.out.println(obj.maxSum(new int[] {1, 3, -1, 0, 4}, 7));
//        System.out.println(obj.maxSum(new int[] {1, 3, -1, 0, 3}, 7));
//        System.out.println(obj.maxSum(new int[]{1, 3, -1, 0, 5}, 7));

        System.out.println(obj.maxSumBinarySearchTree(new int[] {1, 3, -1, 0, 2}, -1));
//        System.out.println(obj.maxSumBinarySearchTree(new int[] {1, 3, -1, 0, 2}, 5));
//        System.out.println(obj.maxSumBinarySearchTree(new int[] {1, 3, -1, 0, 4}, 7));
//        System.out.println(obj.maxSumBinarySearchTree(new int[] {1, 3, -1, 0, 3}, 7));
//        System.out.println(obj.maxSumBinarySearchTree(new int[]{1, 3, -1, 0, 5}, 7));
    }

    public int maxSumBinarySearchTree(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(0);
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            Integer leastLargerElement = treeSet.ceiling(sum - k);
            // if leastLargerElement is null, it means all the elements are smaller than sum - k, which means all x < sum - k ---> k < sum + x
            if (leastLargerElement != null) {
                max = Math.max(max, sum - leastLargerElement);
            }
            System.out.println("treeset: " + treeSet);
            System.out.println("sum: " + sum + ", sum - k: " + (sum - k) + ", leastLargerElement:" + leastLargerElement + ", max: " + max);
            treeSet.add(sum);
        }
        return max;
    }

    public int maxSum(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        int i = 0, j = 0;
        int sum = 0, max = Integer.MIN_VALUE;
        while (j <= nums.length) {
            while (i < j && sum > k) {
                sum -= nums[i];
                i++;
            }

            if (sum <= k) {
                max = Math.max(max, sum);
            }

            if (j < nums.length) sum += nums[j];
            j++;
        }
        return max;
    }
}
