import java.util.Hashtable;



public class ContainsDuplicate {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] test = {1, 2, 3, 4, 5, 6, 2};
        System.out.println("The array contains duplicate: " + containsDuplicate(test));
    }
    public static boolean containsDuplicate(int[] nums) {
        Hashtable<Integer, Integer> map = new Hashtable<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            } else
                return true;
        }
        return false;
    }

}
