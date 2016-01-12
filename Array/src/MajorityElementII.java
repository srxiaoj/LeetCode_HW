import java.util.ArrayList;
import java.util.List;

public class MajorityElementII {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] test = {1, 2, 3, 3, 3, 7, 7, 7, 7, 7, 7};
        System.out.println(majorityElement(test));
        
    }
    public static List<Integer> majorityElement(int[] nums) {
        // the maximum number of elements more than floor(n / 3) is 2 
        List<Integer> list = new ArrayList<Integer>();
        if (nums == null || nums.length == 0) return list;
        int count1 = 0, count2 = 0, candidate1 = 0, candidate2 = 1;
        for (int num : nums) {
            if (num == candidate1) count1++;
            else if (num == candidate2) count2++;
            else if (count1 == 0) {
                candidate1 = num;
                count1 = 1;
            }
            else if (count2 == 0) {
                candidate2 = num;
                count2 = 1;
            }
            else{
                count1--;
                count2--;
            }
        }
        count1 = 0; count2 = 0;
        for (int num : nums) {
            if (num == candidate1) {
                count1 += 2;
            } else {
                count1--;
            }
            if (num == candidate2) {
                count2 += 2;
            } else {
                count2--;
            }
        }
        if (count1 > 0) list.add(candidate1);
        if (count2 > 0) list.add(candidate2);
        return list;
    }
}
