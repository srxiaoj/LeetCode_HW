/**
 * Created by thanksgiving on 6/22/16.
 */
public class NumberComplement {
    public static void main(String[] args) {
        System.out.println(getIntegerComplement(50));
        System.out.println(getIntegerComplement(100));
    }

    static int getIntegerComplement(int n) {
       /* String s = intToBit(n);
        String reverse = reverseBit(s);
        int res = bitToInt(reverse);
        return res;*/

        // 方法2
        String bitWithOnes = intToBitWithOnes(n);
        int reverse = bitToInt(bitWithOnes);
        int res = reverse ^ -1;
        return res;

    }


    // 方法1：得到最高1位 后面的 bit 数, 将 1 与 0 互换位置
    static String intToBit(int num) {
        StringBuilder sb = new StringBuilder();
        if (num >= 0) {
            while (num > 0) {
                int mod = num % 2;
                sb.append(mod);
                num = num / 2;
            }
            return sb.reverse().toString();
        } else {
            sb.append(1);
            sb.append(intToBit(num - Integer.MIN_VALUE));
            return sb.toString();
        }
    }

    static String reverseBit(String s) {
        char[] res = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                res[i] = '0';
            } else {
                res[i] = '1';
            }
        }
        return new String(res);
    }

    // 方法2：得到最高1位的 bit 数，在前面补 1, 与 -1 取 xor
    static String intToBitWithOnes(int num) {
        StringBuilder sb = new StringBuilder();
        if (num >= 0) {
            int totalDigit = 32;
            while (num > 0) {
                int mod = num % 2;
                sb.append(mod);
                num = num / 2;
            }
            for (int i = sb.length(); i < totalDigit; i++) {
                sb.append(1);
            }
            return sb.reverse().toString();
        } else {
            sb.append(1);
            sb.append(intToBit(num - Integer.MIN_VALUE));
            return sb.toString();
        }
    }

    static int bitToInt(String bit) {
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
