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
    public static String multiply(String a, String b) {
        int m = a.length();
        int n = b.length();
        int[] res = new int[m + n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int first = a.charAt(i) - '0';
                int second = b.charAt(j) - '0';
                int product = first * second;
                res[i + j] += (product + res[i + j + 1]) / 10;
                res[i + j + 1] = (product + res[i + j + 1]) % 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < res.length && res[i] == 0) {
            i++;
        }
        while (i < res.length) {
            sb.append(res[i]);
            i++;
        }
        if (sb.length() == 0) {
            return "0";
        }
        return sb.toString();
        /*
        // method 2: BigInteger
        if (num1 == null || num2 == null) return null;
        BigInteger a = new BigInteger(num1);
        BigInteger b = new BigInteger(num2);
        return a.multiply(b).toString();
        */
    }
}
