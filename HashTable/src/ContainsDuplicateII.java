import java.util.HashMap;
import java.util.Map;


public class ContainsDuplicateII {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] test = {1,4,6,8,1,2};
        System.out.println("The array contains duplicate: " + containsNearbyDuplicate(test, 3));
    }
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], i);//store the current position
            } else {
                int lastDupli = map.get(nums[i]);
                if (i - lastDupli <= k) {
                    return true;
                } else {
                    map.put(nums[i], i); //store the new current position
                }
            }
        }
        return false;
    }
}
