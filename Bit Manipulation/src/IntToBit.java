/**
 * Created by thanksgiving on 4/3/16.
 */
public class IntToBit {
    public static void main(String[] args) {
        IntToBit obj = new IntToBit();
        int n1 = 1;
        System.out.println(obj.intToBit(n1));
        int n2 = 2;
        System.out.println(obj.intToBit(n2));
        int n3 = 3;
        System.out.println(obj.intToBit(n3));
        int n4 = 4;
        System.out.println(obj.intToBit(n4));
        int n5 = 5;
        System.out.println(obj.intToBit(n5));
        int n6 = 6;
        System.out.println(obj.intToBit(n6));
    }

    public String intToBit(int num) {
        // print a bit with total length
        int totalDigit = 4;
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            int mod = num % 2;
            sb.append(mod);
            num = num / 2;
        }
        for (int i = sb.length(); i < totalDigit; i++) {
            sb.append(0);
        }
        return sb.reverse().toString();
    }
}
