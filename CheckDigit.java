/**
 * HW2.
 * @author Haorui Wu
 * Andrew ID: haoruiw
 */
public class CheckDigit {

    public static void main(String[] args) {
        String dig = args[0];
        int n = dig.length();
        String[] digits = new String[n];
        int[] code = new int[n];
        for (int i = 0; i < code.length; i++) {
            digits[i] = String.valueOf(dig.charAt(i));
            code[i] = Integer.parseInt(digits[i]);
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                res += 3 * code[i];
            } else {
                res += code[i];
            }
        }
        res = (10 - res % 10) % 10;
        //output
        System.out.println(dig);
        System.out.println(res);
    }
}
