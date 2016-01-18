/**
 * Created by thanksgiving on 1/13/16.
 */
public class FindtheDuplicateNumber {
    public static void main(String[] args) {
        FindtheDuplicateNumber obj = new FindtheDuplicateNumber();
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 5, 10};
        System.out.println("The duplicate number is: " + obj.findDuplicate(a));
    }

    public int findDuplicate(int[] nums) {
        int n = nums.length - 1;
        int l = 1, r = n;
        int mid;
        int count = 0;
        while (l < r) {
            mid = (l + r) / 2;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] <= mid) {
                    count++;
                }
            }
            if (count <= mid) {
                l = mid + 1;
                count = 0;
            } else {
                r = mid;
                count = 0;
            }
        }
        return l;
    }
}
