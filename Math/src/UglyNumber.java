
public class UglyNumber {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int t1 = 8;
        int t2 = 14;
        int t3 = 6;
        System.out.println("t1 is ugly: " + isUgly(t1));
        System.out.println("t2 is ugly: " + isUgly(t2));
        System.out.println("t3 is ugly: " + isUgly(t3));
    }
    public static boolean isUgly(int num) {
        /*Just divide by 2, 3 and 5 as often as possible and then check whether we arrived at 1.
         *  Also try divisor 4 if that makes the code simpler / less repetitive.
         */
        for (int i = 2; i <= 5 && num > 0; i++) {
            while (num % i == 0) {
                num /= i;
            }
        }
        return num == 1;
    }
}
