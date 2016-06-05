/**
 * Created by thanksgiving on 4/3/16.
 */
public class BitToInt {
    public static void main(String[] args) {
        String bit1 = "0001";
        System.out.println(bitToInt(bit1));
        String bit2 = "0011";
        System.out.println(bitToInt(bit2));
        String bit3 = "0101";
        System.out.println(bitToInt(bit3));
        String bit4 = "1101";
        System.out.println(bitToInt(bit4));
        String bit5 = "0111";
        System.out.println(bitToInt(bit5));
        String bit6 = "11111111111111111111111111111111";
        System.out.println(bitToInt(bit6));
        String bit7 = "11111111111111111111111111111110";
        System.out.println(bitToInt(bit7));
    }

    /**
     * 前31位每位按照正常算法计算
     * 到32位如果为1则为 -2147483648 + 前31位结果
     */
    public static int bitToInt(String bit) {
        int n = bit.length();
        if (n > 32) return 0;
        if (n < 32) {
            int res = 0;
            for (int i = 0; i < n; i++) {
                int digit = bit.charAt(i) - '0';
                res += (int) Math.pow(2, n - i - 1) * digit;
            }
            return res;
        } else {
            if (bit.charAt(0) == '0') {
                return bitToInt(bit.substring(1));
            } else {
                return Integer.MIN_VALUE + bitToInt(bit.substring(1));
            }
        }
    }
}
