/**
 * Created by thanksgiving on 3/31/16.
 */
public class Atoi {
    public static void main(String[] args) {
        String a1 = "11231214";
        System.out.println(myAtoi(a1));
        String a2 = "  -123";
        System.out.println(myAtoi(a2));
        String a3 = "1e3 asdf";
        System.out.println(myAtoi(a3));
        String a4 = "1.3";
        System.out.println(myAtoi(a4));
        String a5 = "+1";
        System.out.println(myAtoi(a5));
        String a6 = "9223372036854775809";
        System.out.println(myAtoi(a6));
        String a7 = "abc";
        System.out.println(myAtoi(a7));
        String a8 = "+-2";
        System.out.println(myAtoi(a8));
    }

    /**
     * 注意所有的corner case
     */
    public static int myAtoi(String str) {
        int n = str.length();
        int i = 0, sign = 1;
        int res = 0;
        // remove all blanks at beginning
        while (i < n && str.charAt(i) == ' ') {
            i++;
        }
        if (str.charAt(i) == '-') {
            sign = -1;
            i++;
        } else if (str.charAt(i) == '+') {
            sign = 1;
            i++;
        }

        while (i < n) {
            int c = str.charAt(i) - '0';
            int temp = res * 10 + c;
            if (temp % 10 != c || temp / 10 != res) {
                System.out.println(str + " is not a valid integer");
                return -1;
            } else {
                res = temp;
            }
            i++;
        }
        return sign * res;

/*        int n = str.length();
        int i = 0;
        int sign = 1;
        StringBuilder sb = new StringBuilder();
        while (i < n && str.charAt(i) == ' ') {
            i++;
        }
        if (i == n) return 0;
        if (str.charAt(i) == '+') {
            sign = 1;
            i++;
        } else if (str.charAt(i) == '-') {
            sign = -1;
            i++;
        }
        int digit = 1;
        while (i < n && Character.isDigit(str.charAt(i))) {
            digit++;
            if (digit > 12) {
                break;
            }
            sb.append(str.charAt(i));
            i++;
        }
        if (sb.length() == 0) {
            return 0;
        } else {
            long res = (long) (sign * Long.parseLong(sb.toString()));
            if (res < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            } else if (res > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            } else {
                return (int) (res);
            }
        }*/

       /* if (str.isEmpty()) return 0;
        int sign = 1, base = 0, i = 0;
        while (str.charAt(i) == ' ')
            i++;
        if (str.charAt(i) == '-' || str.charAt(i) == '+')
            sign = str.charAt(i++) == '-' ? -1 : 1;
        while (i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
            if (base > Integer.MAX_VALUE / 10 || (base == Integer.MAX_VALUE / 10 && str.charAt(i) - '0' > 7)) {
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            base = 10 * base + (str.charAt(i++) - '0');
        }
        return base * sign;*/
    }
}
