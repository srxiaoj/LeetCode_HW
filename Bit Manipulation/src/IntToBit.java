public class IntToBit {
    public static void main(String[] args) {
        for (int i = 0; i <= 6; i++) {
            System.out.println(i + " " + intToBit(i));
        }
        System.out.println("-2                             :" + intToBit(-2));
        System.out.println("-2 - (-2147483648) = 2147483646: " + intToBit(-2 - (-2147483648)));
        System.out.println("-1                             :" + intToBit(-1));
        System.out.println("-1 - (-2147483648) = 2147483647: " + intToBit(-1 - (-2147483648)));
        System.out.println(intToBit(Integer.MIN_VALUE));
        System.out.println(intToBit(Integer.MAX_VALUE));
    }

    /**
     * 一直对2取模，所得的余数连接为String再逆过来
     * 负数时先得到 num - (-2147483638)的string，再在最前面append 1
     */
    public static String intToBit(int num) {
        StringBuilder sb = new StringBuilder();
        if (num >= 0) {
            // print a bit with total length
            int totalDigit = 31;
            while (num > 0) {
                int mod = num % 2;
                sb.append(mod);
                num = num / 2;
            }
            for (int i = sb.length(); i < totalDigit; i++) {
                sb.append(0);
            }
            System.out.println(sb.length());
            return sb.reverse().toString();
        } else {
            sb.append(1);
            sb.append(intToBit(num - Integer.MIN_VALUE));
//            System.out.println(sb.length());
            return sb.toString();
        }
    }
}
