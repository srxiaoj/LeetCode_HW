public class TwoSumIIInputArraySorted {

    public static void main(String[] args) {
        int[] test = new int[]{1, 2, 3, 4, 4, 9, 56, 90};
        int[] res = twoSum(test, 8);
        System.out.println("res is: " + res[0] + ", " + res[1]);

//        System.out.println(binarySearch(test, 0, 3, 16));
    }

    /**
     * assume each input has exactly one solution
     */
    public static int[] twoSum(int[] numbers, int target) {
        /**
         * method 1: two pointers
         */
        int[] res = new int[2];
        if (numbers == null || numbers.length < 2)
            return res;
        int l = 0, r = numbers.length - 1;
        while (l < r) {
            long v = numbers[l] + numbers[r];
            if (v == target) {
                res[0] = l + 1;
                res[1] = r + 1;
                break;
            } else if (v > target) {
                r--;
            } else {
                l++;
            }
        }
        return res;
        /**
         * method 2: binary search: O(nlogn)
         */
        /*
        int[] res = new int[2];
        int len = numbers.length;
        for (int i = 0; i < len; i++) {
            int k = target - numbers[i];
            if (binarySearch(numbers, i + 1, len - 1, k) != -1) {
                res[0] = i + 1;
                res[1] = binarySearch(numbers, i + 1, len - 1, k) + 1;
                return res;
            }
        }
        return res;
        */
    }

    /**
     * find the target in num from i to j index, if not found, return -1
     *
     * @param num
     * @param l
     * @param r
     * @param target
     * @return
     */
    private static int binarySearch(int[] num, int l, int r, int target) {
        while (l <= r) {
            int mid = (r + l) / 2;
            if (num[mid] == target) {
                return mid;
            } else if (num[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }
}
