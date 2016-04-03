/**
 * Created by thanksgiving on 4/3/16.
 */
public class BitToInt {
    public static void main(String[] args) {
        BitToInt obj = new BitToInt();
        String bit1 = "0001";
        System.out.println(obj.bitToInt(bit1));
        String bit2 = "0011";
        System.out.println(obj.bitToInt(bit2));
        String bit3 = "0101";
        System.out.println(obj.bitToInt(bit3));
        String bit4 = "1101";
        System.out.println(obj.bitToInt(bit4));
        String bit5 = "0111";
        System.out.println(obj.bitToInt(bit5));
    }

    public int bitToInt(String bit) {
        int n = bit.length();
        int res = 0;
        for (int i = 0; i < n; i++) {
            int digit = bit.charAt(i) - '0';
            res += (int) Math.pow(2, n - i - 1) * digit;
        }
        return res;
    }
}
