/**
 * Created by thanksgiving on 5/16/16.
 */
public class ZigZagConversion {
    public static void main(String[] args) {
        ZigZagConversion obj = new ZigZagConversion();
        String s = "PAYPALISHIRING";
        System.out.println(obj.convert2(s, 3));
    }

    /**
     * P   A   H   N
     * A P L S I I G
     * Y   I   R
     */
    public String convert2(String s, int row) {
        int index = 0;
        StringBuilder[] sb = new StringBuilder[row];
        for (int i = 0; i < sb.length; i++) sb[i] = new StringBuilder();
//        Arrays.fill(sb, new StringBuilder());
        while (index < s.length()) {
            for (int i = 0; i < row && index < s.length(); i++) {
//                if (index >= s.length()) break;
                sb[i].append(s.charAt(index++));
            }
            for (int i = row - 2; i >= 1 && index < s.length(); i--) {
//                if (index >= s.length()) break;
                sb[i].append(s.charAt(index++));
            }
        }
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < row; i++) {
            res.append(sb[i]);
        }
        return res.toString();
    }
    public String convert(String s, int nRows) {
        char[] c = s.toCharArray();
        int len = c.length;
        StringBuffer[] sb = new StringBuffer[nRows];
        for (int i = 0; i < sb.length; i++) sb[i] = new StringBuffer();

        int index = 0;
        while (index < len) {
            for (int i = 0; i < nRows && index < len; i++) {// vertically down
                sb[i].append(c[index]);
                index++;
            }
            for (int i = nRows - 2; i >= 1 && index < len; i--) {// obliquely up
                sb[i].append(c[index]);
                index++;
            }
        }
        for (int i = 1; i < sb.length; i++) {
            sb[0].append(sb[i]);
        }
        return sb[0].toString();
    }
}
