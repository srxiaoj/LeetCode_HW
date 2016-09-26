public class MaximumSubarray {
    public static void main(String[] args) {
        MaximumSubarray obj = new MaximumSubarray();
        int[] a = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] b = {-1, -2, 3, 4, -5, 6};
        System.out.println(obj.maxSubArray(a));
        System.out.println(obj.maxSubArray(b));

        printArray(kadane(a));
        printArray(kadane(b));
    }

    /**
     * 解法1
     * 如果之前sum为负，则sum = nums[i]
     * 否则就在sum基础上加上nums[i]
     * 全局最大为local最大和全局最大比较
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int sum = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (sum < 0) {
                sum = nums[i];
            } else {
                sum += nums[i];

            }
            if (max < sum) {
                max = sum;
            }
        }
        return max;
    }

    /**
     * 求sub array 最大sum
     * 并且输出start, end - > [max, start, end]
     */
    public static int[] kadane(int[] a) {
        int[] result = new int[]{a[0], 0, 0};
        int localMax = a[0], globalMax = a[0];
        int start = 0;
        for (int i = 1; i < a.length; i++) {
            if (localMax < 0) {
                localMax = a[i];
                start = i;
            } else {
                localMax += a[i];
            }
            if (globalMax < localMax) {
                globalMax = localMax;
                result[0] = localMax;
                result[1] = start;
                result[2] = i;
            }
        }
        return result;
    }


    /**
     * 解法2
     * 这类题的关键为记录之前所累计的最大或者最小值(maxPre, minPre)，再在每一轮将这个累计值更新，并与全局最大比较
     */
    public int maxSubArray2(int[] nums) {
/*        int max = nums[0], maxCur = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            maxCur = Math.max(maxCur + nums[i], nums[i]);
            max = Math.max(max, maxCur);
        }
        return max;*/

        int maxPre = nums[0], globalMax = nums[0], max = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(maxPre + nums[i], nums[i]);
            globalMax = Math.max(max, globalMax);
            maxPre = max;
        }
        return globalMax;
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
