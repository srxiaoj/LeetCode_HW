public class MaximumProductSubarray {

    public static void main(String[] args) {
//        int[] test = {2, 3, -2, -4, 1};
//        System.out.println(maxProduct(test));
//
//        int[] test2 = {3, -1, 4};
//        System.out.println(maxProduct(test2));

        int[] test3 = {2, -5, -2, -4, 3};
        System.out.println(maxProduct(test3));

        int[] test4 = {6, 1, -2, 0, 2, -3, -1, 2, 3};
        System.out.println(maxProduct(test4));

        int[] test5 = {-3, -1, 0, 1, 2};
        System.out.println(maxProduct(test5));
    }

    /**
     * 这类题的关键为记录之前所累计的最大或者最小值(maxPre, minPre)，再在每一轮将这个累计值更新，并与全局最大比较
     * 此题一定要maxPre以及minPre这两个额外变量因为maxPre在max以及min的计算方法中都有使用到
     */
    public static int maxProduct(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int maxPre = nums[0];
        int minPre = nums[0];
        int globalMax = nums[0];
        int max, min;

        for (int i = 1; i < nums.length; i++) {
            //if A[i] has the same sign of minPre, then minhere will be the new max
            //use previous max and previous min to get new max
            max = Math.max(Math.max(maxPre * nums[i], minPre * nums[i]), nums[i]);
            min = Math.min(Math.min(maxPre * nums[i], minPre * nums[i]), nums[i]);
            globalMax = Math.max(max, globalMax);
            maxPre = max; // store the previous max value
            minPre = min; // store the previous min value
        }
        return globalMax;
    }
}
