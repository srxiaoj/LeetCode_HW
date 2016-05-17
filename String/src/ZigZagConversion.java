/**
 * Created by thanksgiving on 5/16/16.
 */
public class ZigZagConversion {
    public static void main(String[] args) {
        ZigZagConversion obj = new ZigZagConversion();
        String s = "PAYPALISHIRING";
        System.out.println(obj.convert(s, 3));
    }

    /**
     * P   A   H   N
     * A P L S I I G
     * Y   I   R
     */
    public String convert(String s, int nRows) {
        char[] c = s.toCharArray();
        int len = c.length;
        StringBuffer[] sb = new StringBuffer[nRows];
        for (int i = 0; i < sb.length; i++) sb[i] = new StringBuffer();

        int i = 0;
        while (i < len) {
            for (int index = 0; index < nRows && i < len; index++) {// vertically down
                sb[index].append(c[i]);
                i++;
            }
            for (int index = nRows - 2; index >= 1 && i < len; index--) {// obliquely up
                sb[index].append(c[i]);
                i++;
            }
        }
        for (int index = 1; index < sb.length; index++) {
            sb[0].append(sb[index]);
        }
        return sb[0].toString();
    }
}
