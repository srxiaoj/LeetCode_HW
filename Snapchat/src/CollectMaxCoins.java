/**
 * 题目：A跟B在play game，从int[]里拿数字
 * A：拿第一个/最后一个，都有可能
 * B：greedy，总拿第一个/最后一个中最大的
 * <p>
 * A先开始，然后B，轮流，直到拿完
 * 求A拿到的最大
 * <p>
 * 举个例子：
 * {3, 7, 2, 1}
 * A: {3, 1} -- 4
 * B: {7, 2} -- 9
 * <p>
 * A: {1, 7} -- 8
 * B: {3, 2} -- 5
 * 答案是8
 */
public class CollectMaxCoins {
    public static void main(String[] args) {
        int[] a = {3, 7, 2, 1};
        System.out.println(getMaxForA(a));
    }

    /**
     * A[i][j] 为 A从array的i 到 j 所能取到的最大值
     * 这个最大值可以等于Math.max(nums[i] + A[i+1][j], nums[j] + A[i][j-1])
     * 而根据B的greedy取法特性，A[i+1][j]和A[i][j-1]又可以继续化简
     */
    public static int getMaxForA(int[] nums) {
        int n = nums.length;
        int[][] A = new int[n][n];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                if (i == j || i + 1 == j) {
                    A[i][j] = Math.max(nums[i], nums[j]);
                } else if (i + 1 < j) {
                    int left, right;
                    if (nums[i + 1] > nums[j]) {
                        left = A[i + 2][j];
                    } else {
                        left = A[i + 1][j - 1];
                    }
                    if (nums[i] > nums[j - 1]) {
                        right = A[i + 1][j - 1];
                    } else {
                        right = A[i][j - 2];
                    }
                    A[i][j] = Math.max(nums[i] + left, nums[j] + right);
                }
            }
//            printArray(A);
        }
        return A[0][n - 1];
    }

    public static void printArray(int[][] A) {
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                if (j != A[i].length - 1) {
                    System.out.print(A[i][j] + ", ");
                } else
                    System.out.print(A[i][j]);

            }
            System.out.println("");
        }
        System.out.println("");
    }
}
