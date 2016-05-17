/**
 * Created by thanksgiving on 5/17/16.
 */
public class Numberof1Bits {
    public static void main(String[] args) {
        int n1 = 123;
        System.out.println(hammingWeight(n1));
    }

    /**
     * The trick is you check the last bit of n by performing n & 1 and add it to result.
     * Then perform unsigned right shift >>> until n becomes 0.
     */
    public static int hammingWeight(int n) {
        int result = 0;
        while(n != 0) {
            result += (n & 1);
            n = n >>> 1;
        }
        return result;
    }
}
