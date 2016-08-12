public class StringToLong {
    private static long stringToLong(String s) {
       /* s = s.trim();
        if (s == null || s.length() == 0) return 0;
        int sign = 1;
        if (s.charAt(0) == '+') {
            sign = 1;
            s = s.substring(1);
        } else if (s.charAt(0) == '-') {
            sign = -1;
            s = s.substring(1);
        }

        long res = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') continue;
            if (Character.isDigit(c)) {
                if (res == Long.MAX_VALUE / 10 && Long.MAX_VALUE % 10 <= c - '0' || Long.MAX_VALUE < res) {
                    if (sign == 1) return Long.MAX_VALUE;
                    return Long.MIN_VALUE;
                } else {
                    res = res * 10 + c - '0';
                }
            }
        }
        return sign * res;*/





        if (s == null || s.length() == 0) return 0;
        // trim white space
        s = s.trim();
        if (s.length() < 1) return 0;

        int length = s.length(), i = 0;
        // if s starts with '-', the result is negative
        boolean negative = false;
        if (s.charAt(0) == '-') {
            negative = true;
            i++;
        } else if (s.charAt(0) == '+') {
            i++;
        }

        long result = 0;
        while (i < length && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
            //if overflow, return Long.MAX_VALUE or Long.MIN_VLUE Respectively
            if ((Long.MAX_VALUE / 10 == result && Long.MAX_VALUE % 10 < s.charAt(i)) || Long.MAX_VALUE < result) {
                return negative ? Long.MIN_VALUE : Long.MAX_VALUE;
            }
            result = result * 10 + (s.charAt(i) - '0');
            i++;
        }
        return negative ? -result : result;
    }

    public static void test() {
        long x = stringToLong("    +9223372036854775807");
//        long x = stringToLong("    +0368547 99");
//        long x = stringToLong("    + 0368547 99");
        if (x <= 9223372036854775807l) {
            System.out.println("success");
            System.out.println(x);
        } else {
            System.out.println("failure");
        }
    }

    public static void main(String[] args) {
        test();
    }
}
