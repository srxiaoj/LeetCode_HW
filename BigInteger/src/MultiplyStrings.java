public class MultiplyStrings {

    public static void main(String[] args) {
        String num1 = "25";
        String num2 = "37";
//        System.out.println(multiply(num1, num2));

        String num3= "123";
        String num4 = "456";
        System.out.println(multiply(num3, num4));
    }

    /**
     * 模拟乘法操作, 注意要进位
     *      456
     *    x 123
     * --------
     *       18
     *      15
     *     12
     *      12
     *     10
     *     8
     *    6
     *   5
     *  4
     */
    public static String multiply(String num1, String num2) {
        int len1 = num1.length(), len2 = num2.length();
        int[] res = new int[len1 + len2];
        for (int i = len1 - 1; i >= 0; i--) {
            for (int j = len2 - 1; j >= 0; j--) {
                int tmp = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                res[i + j] += (tmp + res[i + j + 1]) / 10;
                if (res[i + j] > 9) {
                    res[i + j - 1] += 1;
                    res[i + j] = res[i + j] % 10;
                }
                res[i + j + 1] = (tmp + res[i + j + 1]) % 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i : res) {
            if (sb.length() > 0 || i > 0) {
                sb.append(i);
            }
        }
        return sb.length() == 0 ? "0" : sb.toString();
        /*
        // method 2: BigInteger
        if (num1 == null || num2 == null) return null;
        BigInteger a = new BigInteger(num1);
        BigInteger b = new BigInteger(num2);
        return a.multiply(b).toString();
        */
    }
}
