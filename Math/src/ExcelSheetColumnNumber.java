/**
 * Created by thanksgiving on 5/18/16.
 */
public class ExcelSheetColumnNumber {
    public static void main(String[] args) {
        System.out.println(titleToNumber("AA"));
        System.out.println(titleToNumber("AAA"));
    }

    public static int titleToNumber(String s) {
        if (s == null || s.length() == 0) return 0;
        int n = s.length();
        int res = 0;
        int i = 0;
        while (i < n) {
            res = res * 26 + (s.charAt(i) - 'A' + 1);
            i++;
        }
        return res;
    }
}
