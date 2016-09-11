import java.util.Arrays;

/**
 * Created by thanksgiving on 8/5/16.
 */
public class MaximumGap {
    public static void main(String[] args) {
        System.out.println(maximumGap(new int[] {10, 3, 1, 2, 11, 4, 5, 6}));
        System.out.println(maximumGap(new int[] {1, 1000000}));
        System.out.println(maximumGap(new int[] {3, 6, 9, 1}));
    }

    public static int maximumGap(int[] nums) {
        int n = nums.length;
        if (n < 2) return 0;
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int i : nums) {
            max = Math.max(i, max);
            min = Math.min(i, min);
        }

        int gap = (int) (Math.ceil((double) (max - min + 1) / n));
        if (gap == 0) return 0;
        System.out.println("gap: " + gap);
        int[] maxBucket = new int[n];
        int[] minBucket = new int[n];
        Arrays.fill(minBucket, Integer.MAX_VALUE);
        Arrays.fill(maxBucket, Integer.MIN_VALUE);

        for (int i = 0; i < n; i++) {
            int idx = (nums[i] - min) / gap;
            maxBucket[idx] = Math.max(maxBucket[idx], nums[i]);
            minBucket[idx] = Math.min(minBucket[idx], nums[i]);
        }
        printArray(minBucket);
        printArray(maxBucket);

        int pre = min;
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (minBucket[i] != Integer.MAX_VALUE) {
                res = Math.max(res, minBucket[i] - pre);
            }
            if (maxBucket[i] != Integer.MIN_VALUE) {
                pre = maxBucket[i];
            }
        }
        return res;



       /* if (nums == null || nums.length < 2)
            return 0;
        // get the max and min value of the array
        int min = nums[0];
        int max = nums[0];
        for (int i : nums) {
            min = Math.min(min, i);
            max = Math.max(max, i);
        }
        // the minimum possibale gap, ceiling of the integer division
        int gap = (int) Math.ceil((double) (max - min) / (nums.length - 1));
        System.out.println("gap: " + gap);
        int[] bucketsMIN = new int[nums.length - 1]; // store the min value in that bucket
        int[] bucketsMAX = new int[nums.length - 1]; // store the max value in that bucket
        Arrays.fill(bucketsMIN, Integer.MAX_VALUE);
        Arrays.fill(bucketsMAX, Integer.MIN_VALUE);
        // put numbers into buckets
        for (int i : nums) {
            if (i == min || i == max)
                continue;
            int idx = (i - min) / gap; // index of the right position in the buckets
            bucketsMIN[idx] = Math.min(i, bucketsMIN[idx]);
            bucketsMAX[idx] = Math.max(i, bucketsMAX[idx]);
        }
        printArray(bucketsMAX);
        printArray(bucketsMIN);

        // scan the buckets for the max gap
        int maxGap = Integer.MIN_VALUE;
        int previous = min;
        for (int i = 0; i < nums.length - 1; i++) {
            if (bucketsMIN[i] == Integer.MAX_VALUE && bucketsMAX[i] == Integer.MIN_VALUE)
                // empty bucket
                continue;
            // min value minus the previous value is the current gap
            maxGap = Math.max(maxGap, bucketsMIN[i] - previous);
            // update previous bucket value
            previous = bucketsMAX[i];
        }
        maxGap = Math.max(maxGap, max - previous); // updata the final max value gap
        return maxGap;*/
    }

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
