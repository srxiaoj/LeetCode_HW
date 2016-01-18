/**
 * Created by thanksgiving on 1/18/16.
 */
public class PowerofThree {
    public static void main(String[] args) {
        PowerofThree obj = new PowerofThree();
        System.out.println(obj.isPowerOfThree(0));
        System.out.println(obj.isPowerOfThree(45));
        System.out.println(obj.isPowerOfThree(27));
        System.out.println(obj.isPowerOfThree(999));
        System.out.println(obj.isPowerOfThree(1162261467));
    }

    public boolean isPowerOfThree(int n) {
        double x = Math.log(n) / Math.log(3);
        return (Math.abs(x - Math.rint(x)) <= 0.00000000000001);

       /* while ((n % 3 == 0) && n > 1) {
            n /= 3;
        }
        return n == 1;*/

        /*long copy = n;
        if (n <= 0) return false;
        long x = 1;
        while (n > 0) {
            n = n / 3;
            x = x * 3;
        }
        x = x / 3;
        if (x == copy) return true;
        return false;*/
    }
}
