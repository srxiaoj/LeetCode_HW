import java.util.HashSet;
import java.util.Set;

/**
 * Created by Administrator on 2016/10/22.
 */
public class MaximumXORofTwoNumbersinanArray {
    public static void main(String[] args) {
        System.out.println(findMaximumXOR(new int[]{3, 10, 5, 25}));
//        System.out.println(findMaximumXOR(new int[]{3, 10, 5, 25, 2, 8}));
//        System.out.println(findMaximumXOR(new int[]{2147483647, 2147483646}));
    }

    public static int findMaximumXOR(int[] nums) {
        int max = 0, mask = 0;
        int digit = 0;
        for (int i : nums) {
            digit = Math.max(digit, countDigits(i));
        }

        for (int i = digit; i >= 0; i--) {
            mask = mask | (1 << i);
            System.out.println("********current mask: " + Integer.toBinaryString(mask) + "*********");
            Set<Integer> set = new HashSet<>();
            System.out.println("mask current bit to each number in array, if get 0, means no bit in current digit");
            for (int num : nums) {
                set.add(num & mask);
                System.out.println(Integer.toBinaryString(num) + " & " + Integer.toBinaryString(mask) + ": " + Integer.toBinaryString((num & mask)));
            }
            int tmp = max | (1 << i);
            System.out.println("tmp: " + Integer.toBinaryString(tmp));
            for (int prefix : set) {
                if (set.contains(tmp ^ prefix)) {
                    System.out.println("found max: " + Integer.toBinaryString(tmp) + " ^ " + Integer.toBinaryString(prefix) + ": " + Integer.toBinaryString((tmp ^ prefix)));
                    max = tmp;
                    break;
                }
            }
        }
        return max;
    }

    /**
     * 得到一共多少bit位
     */
    public static int countDigits(int n) {
        int digit = 0;
        int temp = n;
        while(temp != 0) {
            digit++;
            temp = temp >> 1;
        }
        return digit;
    }
}
