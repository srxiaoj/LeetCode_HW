
public class CountandSay {

    public static void main(String[] args) {
        CountandSay obj = new CountandSay();
        String sequence = "1, 11, 21, 1211, 111221, 312211,"
                + "13112221, 1113213211, 31131211131221...";
        System.out.println(obj.countAndSay(4));
    }

    public String countAndSay(int n) {
        int i = 1;
        String next = "1";
        while (i < n) {
            next = read(next);
            i++;
        }
        return next;
    }

    private String read(String s) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < s.length()) {
            int count = 1;
            while (i + 1 < s.length() && s.charAt(i) == s.charAt(i + 1)) {
                i++;
                count++;
            }
            sb.append(count).append(s.charAt(i));
            i++;
        }
        return sb.toString();
    }
}
