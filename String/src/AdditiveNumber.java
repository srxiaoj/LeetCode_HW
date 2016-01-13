/**
 * Created by thanksgiving on 1/12/16.
 */
public class AdditiveNumber {
    public static void main(String[] args) {
        AdditiveNumber obj = new AdditiveNumber();
        String a = "112334";
        String b = "199100199";
        String c = "1121325";
        String d = "1023";
        String e = "0235813";
        String f = "198019823962";
        String g = "121474836472147483648";
        String h = "221474836472147483649";
        System.out.println(obj.isAdditiveNumber(a));
        System.out.println(obj.isAdditiveNumber(b));
        System.out.println(obj.isAdditiveNumber(c));
        System.out.println(obj.isAdditiveNumber(d));
        System.out.println(obj.isAdditiveNumber(e));
        System.out.println(obj.isAdditiveNumber(f));
        System.out.println(obj.isAdditiveNumber(g));
        System.out.println(obj.isAdditiveNumber(h));
    }

    public boolean isAdditiveNumber(String num) {
        if (num.length() < 3) return false;
        int start = 0;
        int i = 1, j = i + 1;
        boolean curResult = false;
        while (i < num.length() - 1) {
            int tmpi = i;
            int tmpj = j;
            while (j < num.length()) {
                long first = Long.parseLong(num.substring(start, i));
                long second = Long.parseLong(num.substring(i, j));
                long sum = first + second;
                long Max = (long) Integer.MAX_VALUE + 1;
                if (first > Long.MAX_VALUE || second > Long.MAX_VALUE || sum > Long.MAX_VALUE) {
                    break;
                }

                String sumStr = String.valueOf(sum);
                if (j < num.length()) {
                    if (j + sumStr.length() <= num.length() && num.substring(j, j + sumStr.length()).equals(sumStr)) {
                        start = i;
                        i = j;
                        j = j + sumStr.length();
                        curResult = true;
                    } else {
                        // reset start, i;
                        start = 0;
                        i = tmpi;
                        tmpj++;
                        j = tmpj;
                        curResult = false;
                        // leading number cannot be 0 if num.length > 1
                        if (j - i > 1 && num.charAt(i) == '0') {
                            tmpi++;
                            i = tmpi;
                            tmpj = tmpi + 1;
                            curResult = false;
                        }
                    }
                }
            }
            if (j == num.length() && curResult == true) {
                return true;
            }
            i = tmpi + 1;
            j = i + 1;
            if (num.charAt(0) == '0') {
                return curResult;
            }
        }
        return curResult;
    }
}
