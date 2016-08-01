import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by thanksgiving on 5/16/16.
 */
public class LargestNumber {
    public static void main(String[] args) {
        LargestNumber obj = new LargestNumber();
        int[] nums1 = {75777, 757};
        int[] nums2 = {67, 6};
        int[] nums3 = {64, 6};
        int[] nums4 = {66, 6};
        int[] nums5 = {0, 0};
        int[] nums6 = {0};
        System.out.println(obj.largestNumber(nums1));
        System.out.println(obj.largestNumber(nums2));
        System.out.println(obj.largestNumber(nums3));
        System.out.println(obj.largestNumber(nums4));
        System.out.println(obj.largestNumber(nums5));
        System.out.println(obj.largestNumber(nums6));
    }

    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) return "";
        String[] array = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            array[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(array, new MyComparator());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                while (i < nums.length && array[i].equals("0")) {
                    i++;
                }
                if (i == nums.length) return "0";
            }
            sb.append(array[i]);
        }
        return sb.toString();
    }

    /**
     * 方法1
     * 将a + b 与 b + a对比，来比较排序
     */
    class MyComparator implements Comparator<String> {
        public int compare(String a, String b) {
            String first = a + b;
            String second = b + a;
            if (first.compareTo(second) < 0) {
                return 1;
            } else if (first.compareTo(second) > 0) {
                return -1;
            }
            return 0;
        }
    }




    /**
     * 方法2
     * 很多cornner case, 见例子
     */
    public String largestNumber2(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                String a = String.valueOf(nums[j]);
                String b = String.valueOf(nums[i]);
                if (larger(b, a)) {
                    swap(nums, i, j);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        // 如果有多个0，要把0开头去掉，如果全部是0，保留一个0
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 && nums[i] == 0) {
                while (i < nums.length && nums[i] == 0) {
                    if (i == nums.length - 1) {
                        sb.append(0);
                    }
                    i++;
                }
            } else {
                sb.append(nums[i]);
            }
        }
        return sb.toString();
    }

    /**
     * return whether a should be in front of b
     */
    private boolean larger(String a, String b) {
        int len1 = a.length();
        int len2 = b.length();
        if (len1 > len2) return !larger(b, a);
        if (a.equals("")) return true;
        for (int i = 0; i < len1; i++) {
            char c1 = a.charAt(i);
            char c2 = b.charAt(i);
            if (c1 > c2) {
                return true;
            } else if (c1 < c2) {
                return false;
            }
        }

        // if all the characters are equals in the range of len1
        return larger(a, b.substring(len1));
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
