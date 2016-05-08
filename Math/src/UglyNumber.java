
public class UglyNumber {

    public static void main(String[] args) {
        int t1 = 8;
        int t2 = 14;
        int t3 = -8;
        System.out.println("t1 is ugly: " + isUgly(t1));
        System.out.println("t2 is ugly: " + isUgly(t2));
        System.out.println("t3 is ugly: " + isUgly(t3));
    }
    public static boolean isUgly(int num) {
        /*Just divide by 2, 3 and 5 as often as possible and then check whether we arrived at 1.
         *  Also try divisor 4 if that makes the code simpler / less repetitive.
         */
        if (num <= 0) return false;
        while (num > 1) {
            if (num % 2 == 0) {
                num /= 2;
            } else if (num % 3 == 0) {
                num /= 3;
            } else if (num % 5 == 0) {
                num /= 5;
            } else {
                return false;
            }
        }
        return true;
    }
}
