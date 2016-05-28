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
       /* StringBuilder sb = new StringBuilder();
        while (n > 0) {
//            char c = (char) ((n - 1) % 26 + 'A');
            int tmp = n % 26 + 26;
            char c = (char) ((n % 26 + 25) % 26 + 'A');
            sb.append(c);
            n = (n - 1) / 26;
        }
        return sb.reverse().toString();*/

        if ((n - 1) / 26 == 0) return String.valueOf ((char) ((n - 1) % 26 + 'A'));
        String first = String.valueOf((char)((n - 1) % 26 + 'A'));
        String sub = convertToTitle((n - 1) / 26);
        return sub + first;
    }
}
