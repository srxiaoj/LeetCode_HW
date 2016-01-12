import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class ContainsDuplicateIII {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] test = {-1,2147483647};
        int[] test2 = {1,4,6,8};
        int[] test3 = {2,1};
        System.out.println("The array contains duplicate: " + containsNearbyAlmostDuplicate(test, 1, 2147483647));
        System.out.println("The array contains duplicate: " + containsNearbyAlmostDuplicate(test2, 1, 5));
        System.out.println("The array contains duplicate: " + containsNearbyAlmostDuplicate(test3, 1, 1));
    }
    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        if (n > 10000) {
            for (int i = 0; i < n; i++) {
                if (!map.containsKey(nums[i]))
                    map.put(nums[i], i);
                for (int j = 1; j <= t; j++) {
                    if (map.containsKey(nums[i]+j)) {
                        int lastPos = map.get(nums[i]+j);
                        if (i - lastPos <= k) {
                            return true;
                        } else {
                            map.put(nums[i], i);
                        }
                    } 
                    
                }
            }
        } else {
        for (int i = 0; i < n; i++) {
            if (!map.containsKey(nums[i]))
                map.put(nums[i], i);
            for (int j = 1; j <= k; j++) {
                if (i+j < n && Math.abs(nums[i+j]-nums[i]) <= t) {
                    if ((long) nums[i+j] - (long) nums[i] <= (long) t) {
                        return true;
                    }
                } else {
                        map.put(nums[i], i);
                }
            }
        }
        }
        return false;
    }

}
