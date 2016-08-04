import java.util.TreeMap;


public class ContainsDuplicateIII {

    public static void main(String[] args) {
        int[] test = {-1, 2147483647};
        int[] test2 = {1, 4, 6, 8};
        int[] test3 = {2, 1};
//        System.out.println("The array contains duplicate: " + containsNearbyAlmostDuplicate(test, 1, 2147483647));
//        System.out.println("The array contains duplicate: " + containsNearbyAlmostDuplicate(test2, 1, 5));
//        System.out.println("The array contains duplicate: " + containsNearbyAlmostDuplicate(test3, 1, 1));
//        System.out.println("The array contains duplicate: " + containsNearbyAlmostDuplicate(new int[]{1, 2}, 0, 1));
//        System.out.println("The array contains duplicate: " + containsNearbyAlmostDuplicate(new int[]{-1, -1}, 1, 0));
        System.out.println("The array contains duplicate: " + containsNearbyAlmostDuplicate(new int[]{0, 10, 22, 15, 0, 5, 22, 12, 1, 5}, 3, 3));
    }

    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length == 0) return false;
        TreeMap<Long, Integer> tree = new TreeMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (tree.size() <= k) {
                long max = (long) nums[i] + t;
                long min = (long) nums[i] - t;
                if (tree.floorKey(max) != null && tree.floorKey(max) >= min) {
                    return true;
                }
            }
            if (tree.size() == k)
                tree.remove((long) nums[i - k]);
            tree.put((long) nums[i], i);
        }
        return false;
    }

}
