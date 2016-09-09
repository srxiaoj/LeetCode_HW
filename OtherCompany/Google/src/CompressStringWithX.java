/**
 * Created by thanksgiving on 9/6/16.
 */
public class CompressStringWithX {
    public static void main(String[] args) {
//        System.out.println(encode("aaaabbbcc"));
//        System.out.println(encode("aaaabbbccggggg"));
//        System.out.println(encode("aaaabbbccxxxx"));
        System.out.println(encode("333"));
        System.out.println(encode("3x3"));
        System.out.println(encode("3xx"));
        System.out.println(encode("xxx"));
        System.out.println(encode("31xx"));
        System.out.println(encode("1xx"));
        System.out.println(encode("0xx"));
        System.out.println(encode("xxxxxxxxxxx"));

        System.out.println("----DECODE----");
        System.out.println(decode(encode("333")));
        System.out.println(decode(encode("3x3")));
        System.out.println(decode(encode("3xx")));
        System.out.println(decode(encode("xxx")));
        System.out.println(decode(encode("31xx")));
        System.out.println(decode(encode("1xx")));
        System.out.println(decode(encode("0xx")));
        System.out.println(decode(encode("xxxxxxxxxxx")));
    }

    public static String encode(String s) {
        int count = 1;
        char cur = s.charAt(0);

        int i = 1;
        int start = 0;
        StringBuilder sb = new StringBuilder();
        while (i <= s.length()) {
            while (i < s.length() && s.charAt(i) == cur) {
                i++;
                count++;
            }
            if (count > 2) {
                sb.append(count).append('x').append(cur);
            } else {
                for (int index = start; index < i; index++) {
                    if (s.charAt(index) == 'x') {
                        sb.append(1).append('x').append('x');
                    } else {
                        sb.append(1).append('x').append(s.charAt(index));
                    }
                }
            }
            if (i == s.length()) {
                break;
            }
            count = 1;
            cur = s.charAt(i);
            start = i;
            i++;
        }
        return sb.toString();
    }

    public static String decode(String s) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < s.length()) {
            int posOfX = s.indexOf('x', i);
            int num = Integer.parseInt(s.substring(i, posOfX));
            char c = s.charAt(posOfX + 1);
            if (num == 1) {
                sb.append(c);
            } else {
                for (int k = 0; k < num; k++) {
                    sb.append(c);
                }
            }
            i = posOfX + 2;
        }
        return sb.toString();
    }
}
