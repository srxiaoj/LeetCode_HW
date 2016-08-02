
public class DecodeWays {
    public static void main(String[] args) {
        System.out.println(numDecodings("00"));
        System.out.println(numDecodings("123"));
        System.out.println(numDecodings("2123"));
        System.out.println(numDecodings("1"));
        System.out.println(numDecodings("101"));
    }
    public static int numDecodings(String s) {
        int n = s.length();
        if (n == 0) return 0;
        int[] res = new int[n + 1];
        res[n] = 1;
        if (s.charAt(n - 1) == '0') { //'0' does not decode into any character
            res[n - 1] = 0;
        } else {
            res[n - 1] = 1;
        }
        for (int i = n - 2; i >= 0; i--) {
            if (s.charAt(i) != '0') {
                int sub = Integer.parseInt(s.substring(i, i + 2)); //get the past two characters, check whether it's less than 26
                if (sub <= 26) {
                    res[i] = res[i + 1] + res[i + 2]; //core step - Catalan number?
                } else {
                    res[i] = res[i + 1];
                }
            }
        }
        return res[0];
    }
}
