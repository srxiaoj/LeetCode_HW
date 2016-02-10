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

        //wrong answer
        /*if (nums == null || nums.length == 0) return 0;
        int k = 0;
        while (k < nums.length && nums[k] == 0) k++;
        if (k >= nums.length) return 0;
        int max = nums[k];
        int min = nums[k];
        int globalMax = nums[k];
        boolean productIsPos;
        if (nums[k] > 0) productIsPos = true;
        else productIsPos = false;
        for (int i = k + 1; i < nums.length; i++) {
            if (nums[i] > 0) {
                if (productIsPos == true) {
                    max = nums[i] * max;
                    globalMax = Math.max(max, globalMax);
                } else {
                    if (nums[i] > max) {
                        max = nums[i];
                        globalMax = nums[i];
                    }
                    min = nums[i] * min;
                    productIsPos = false;
                }
            } else if (nums[i] < 0) {
                if (productIsPos == true) {
                    min = nums[i] * max;
                    productIsPos = false;
                    // globalMax = Math.max(min, globalMax);
                } else {
                    max = nums[i] * min;
                    globalMax = Math.max(max, globalMax);
                    productIsPos = true;
                }
            } else { // nums[i] == 0
                if (i + 1 < nums.length) {
                    i++;
                    max = nums[i];
                    min = nums[i];
                    if (nums[i] > 0) productIsPos = true;
                    else productIsPos = false;
                    globalMax = Math.max(Math.max(max, 0), globalMax);
                }
            }
        }
        return globalMax;*/

        if (nums.length == 0) {
            return 0;
        }

        int maxherepre = nums[0];
        int minherepre = nums[0];
        int maxsofar = nums[0];
        int maxhere, minhere;

        for (int i = 1; i < nums.length; i++) {
            //if A[i] has the same sign of minherepre, then minhere will be the new max
            maxhere = Math.max(Math.max(maxherepre * nums[i], minherepre * nums[i]), nums[i]); //use previous max and previous min to get new max
            minhere = Math.min(Math.min(maxherepre * nums[i], minherepre * nums[i]), nums[i]);
            maxsofar = Math.max(maxhere, maxsofar);
            maxherepre = maxhere; // store the previous max value
            minherepre = minhere; // store the previous min value
        }
        return maxsofar;
    }
}
