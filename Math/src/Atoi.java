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
    }

    public static int myAtoi(String str) {
        if (str.isEmpty()) return 0;
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
        return base * sign;
    }
}
