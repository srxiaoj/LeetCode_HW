/**
 * Created by thanksgiving on 9/19/16.
 */
public class SummaryRanges {
    public static void main(String[] args) {
        System.out.println(convert(new int[] {}));
        System.out.println(convert(new int[] {1, 2, 3, 5, 6, 8, 9, 10}));
        System.out.println(convert(new int[] {1, 2, 3, 5, 5, 5, 9}));
        System.out.println(convert(new int[] {1, 2, 3, 5, 5, 6, 7}));
        System.out.println(convert(new int[] {1, 2, 4, 5, 7, 9}));
        System.out.println(convertFollowUp(new int[] {1, 3, 5, 6, 9, 12}));
        System.out.println(convertFollowUp(new int[] {1, 3, 5, 6, 9, 12, 18}));
    }

    /**
     * ［1，2，3， 5， 6， 8， 9 ，10］，要求输出"1-3, 5-6, 8-10"
     * 1，2，3，5，5，5  ->  "1->3, 5->5"
     * 1,2,3,5,5,6,7 -> "1->3, 5->7";
     *
     * 然后又follow up:
     * 如果允许间隔不一定是1: 比如：
     *
     * 1,3,5,6,9,12 ->" 1->5/2, 6->12/3"  同时输入range和间隔。
     */
    public static String convert(int[] nums) {
        StringBuilder sb = new StringBuilder();
        if (nums == null || nums.length == 0) return sb.toString();
        int n = nums.length;

        int i = 0;
        while (i + 1 < n) {
            int start = i;
            while (i + 1 < n && (nums[i + 1] == nums[i] + 1 || nums[i + 1] == nums[i])) {
                i++;
            }

            if (i == start) {
                sb.append(nums[i]).append(", ");
            } else {
                sb.append(nums[start] + "->" + nums[i] + ", ");
            }
            i++;
        }
//        System.out.println("i: " + i + ", n " + n);
//        if (n > 1 && !(nums[n - 1] == nums[n - 2] || nums[n - 1] == nums[n - 2] + 1)) {
        if (n == i + 1) {
            sb.append(nums[n - 1]).append(", ");
        }
        String res = sb.substring(0, sb.length() - 2);
        return res;
    }

    public static String convertFollowUp(int[] nums) {
        StringBuilder sb = new StringBuilder();
        if (nums == null || nums.length == 0) return sb.toString();
        int n = nums.length;

        int i = 0;
        while (i + 1 < n) {
            int start = i;
            int interval = nums[i + 1] - nums[i];
            while (i + 1 < n && nums[i + 1] - nums[i] == interval) {
                i++;
            }
            sb.append(nums[start] + "->" + nums[i] + "/" + interval + ", ");
            i++;
        }
        if (i + 1 == n) {
            sb.append(nums[i]).append(", ");
        }
        String res = sb.substring(0, sb.length() - 2);
        return res;
    }
}
