/**
 * Created by thanksgiving on 5/20/16.
 */
public class ExcelSheetColumnTitle {
    public static void main(String[] args) {
        System.out.println(convertToTitle(1));
        System.out.println(convertToTitle(26));
        System.out.println(convertToTitle(27));
        System.out.println(convertToTitle(28));
        System.out.println(convertToTitle(52));
        System.out.println(convertToTitle(200));

    }

    public static String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            char c = (char) ((n - 1) % 26 + 'A');
            sb.append(c);
            n = (n - 1) / 26;
        }
        return sb.reverse().toString();
    }
}
