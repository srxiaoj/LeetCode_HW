import java.math.BigInteger;

public class MultiplyStrings {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String num1 = "25";
        String num2 = "37";
        System.out.println(multiply(num1, num2));
    }
    public static String multiply(String num1, String num2) {
        int len1 = num1.length(), len2 = num2.length();
        int[] res = new int[len1 + len2];
        for (int i = len1 - 1; i >= 0; i--) {
            for (int j = len2 - 1; j >= 0; j--) {
                int tmp = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                res[i + j] = (tmp + res[i + j + 1]) / 10;
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
