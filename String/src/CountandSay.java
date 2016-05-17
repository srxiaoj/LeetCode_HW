
public class CountandSay {

    public static void main(String[] args) {
        CountandSay obj = new CountandSay();
        String sequence = "1, 11, 21, 1211, 111221, 312211,"
                + "13112221, 1113213211, 31131211131221...";
        System.out.println(obj.countAndSay(4));
    }
    public String countAndSay(int n) {
        if (n <= 0)
            return "-1";
        String result = "1";

        for (int i = 1; i < n; i++) {
            result = build(result);
        }
        return result;
    }

    private String build(String result) {
        StringBuilder builder = new StringBuilder();
        int i = 0;
        while (i < result.length()) {
            char val = result.charAt(i);
            int count = 0;

            while (i < result.length() && result.charAt(i) == val) {
                i++;
                count++;
            }
            builder.append(String.valueOf(count)).append(val);
        }
        return builder.toString();
    }
}
