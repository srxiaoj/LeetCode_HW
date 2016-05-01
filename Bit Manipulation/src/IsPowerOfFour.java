/**
 * Created by thanksgiving on 4/30/16.
 */
public class IsPowerOfFour {
    public static void main(String[] args) {
        IsPowerOfFour obj = new IsPowerOfFour();
        System.out.println(obj.isPowerOfFour(0));
        System.out.println(obj.isPowerOfFour(1));
        System.out.println(obj.isPowerOfFour(3));
        System.out.println(obj.isPowerOfFour(4));
        System.out.println(obj.isPowerOfFour(16));
        System.out.println(obj.isPowerOfFour(4782968));
    }

    public boolean isPowerOfFour(int num) {
        int cur = 1;
        while (cur > 0 && cur < num) {
            cur = cur << 2;
        }
        return cur == num;
    }
}
