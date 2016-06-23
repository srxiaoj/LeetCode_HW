/**
 * Created by thanksgiving on 6/22/16.
 */
public class NumberComplement {
    public static void main(String[] args) {
        System.out.println(getIntegerComplement(50));
        System.out.println(getIntegerComplement(100));
    }

    static int getIntegerComplement(int n) {
        String s = intToBit(n);
        System.out.println(s);
        String reverse = reverseBit(s);
        System.out.println(reverse);
        int res = bitToInt(reverse);
        return res;

    }

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
