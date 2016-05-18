/**
 * Created by thanksgiving on 5/18/16.
 */
public class RemoveElement {
    public static void main(String[] args) {
        RemoveElement obj = new RemoveElement();
        int[] num = {3,2,2,3};
        System.out.println(obj.removeElement(num, 3));
    }

    public int removeElement(int[] nums, int val) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] == val) {
                int j = i + 1;
                while (j < nums.length && nums[j] == val) {
                    j++;
                }
                if (j == nums.length) {
                    return i;
                }
                swap(nums, i, j);
            }
            i++;
        }
        return i;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
