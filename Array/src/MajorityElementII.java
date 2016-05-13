import java.util.ArrayList;
import java.util.List;

public class MajorityElementII {

    public static void main(String[] args) {
        int[] test = {1, 2, 3, 3, 3, 7, 7, 7, 7, 7, 7};
        int[] test2 = {0, 0, 0};
        System.out.println(majorityElement(test));
        System.out.println(majorityElement(test2));

    }

    /**
     * 初始化vote1 = 0, vote2 = 1， 先寻找到vote1以及vote2
     * 然后判断vote1, vote2是否大于 n / 3个
     */
    public static List<Integer> majorityElement(int[] nums) {
        // the maximum number of elements more than floor(n / 3) is 2
        List<Integer> list = new ArrayList<Integer>();
        if (nums == null || nums.length == 0) return list;
        int count1 = 0, count2 = 0, vote1 = 0, vote2 = 1;
        for (int num : nums) {
            if (num == vote1) count1++;
            else if (num == vote2) count2++;
            else if (count1 == 0) {
                vote1 = num;
                count1 = 1;
            } else if (count2 == 0) {
                vote2 = num;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }
        // to make sure count1 and count2 is larger than n / 3
        count1 = 0;
        count2 = 0;
        for (int num : nums) {
            if (num == vote1) {
                count1 += 2;
            } else {
                count1--;
            }
            if (num == vote2) {
                count2 += 2;
            } else {
                count2--;
            }
        }
        if (count1 > 0) list.add(vote1);
        if (count2 > 0) list.add(vote2);
        return list;
    }
}
