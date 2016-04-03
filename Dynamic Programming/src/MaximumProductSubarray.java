public class MaximumProductSubarray {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
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
    public static int maxProduct(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int maxherepre = nums[0];
        int minherepre = nums[0];
        int maxsofar = nums[0];
        int maxhere, minhere;

        for (int i = 1; i < nums.length; i++) {
            //if A[i] has the same sign of minherepre, then minhere will be the new max
            //use previous max and previous min to get new max
            maxhere = Math.max(Math.max(maxherepre * nums[i], minherepre * nums[i]), nums[i]);
            minhere = Math.min(Math.min(maxherepre * nums[i], minherepre * nums[i]), nums[i]);
            maxsofar = Math.max(maxhere, maxsofar);
            maxherepre = maxhere; // store the previous max value
            minherepre = minhere; // store the previous min value
        }
        return maxsofar;
    }
}
