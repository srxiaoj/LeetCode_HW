/**
 * Created by thanksgiving on 8/22/16.
 */
public class SuperPow {
    public static void main(String[] args) {
        for (int i = 0; i <= 20; i++) {
            System.out.print(Math.pow(2, i) % 1337 + " ");
        }
        System.out.println();
        for (int i = 0; i < 20; i++) {
            double res = Math.pow(2, i) % 1337 * Math.pow(2, 20 - i) % 1337;
            System.out.print(res + " ");
        }
    }


}
