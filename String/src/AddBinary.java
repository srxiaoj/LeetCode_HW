public class AddBinary {

    public static void main(String[] args) {
        AddBinary obj = new AddBinary();
        String a = "11";
        String b = "1";
        System.out.println(obj.addBinary(a, b));
        
    }

    /**
     * 从右往左两位相加，如果大于1则进位
     */
    public String addBinary(String a, String b) {
        if (a == null || a.length() == 0) return b;
        if (b == null || b.length() == 0) return a;
        int m = a.length(), n = b.length();
        if (m < n) return addBinary(b, a);

        int i = n - 1;
        String res = "";
        int sum = 0;
        while (i >= 0) {
            int digitA = a.charAt(i + m - n) - '0';
            int digitB = b.charAt(i) - '0';
            sum += digitA + digitB;
            res = (sum % 2) + res;
            sum /= 2;
            i--;
        }
        while ((m - n + i) >= 0) {
            int digitA = a.charAt(i + m - n) - '0';
            sum += digitA;
            res = (sum % 2) + res;
            sum /= 2;
            i--;
        }
        if (sum == 1) {
            res = 1 + res;
        }
        return res;
    }
}
