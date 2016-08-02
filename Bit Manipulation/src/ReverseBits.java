/**
 * Created by thanksgiving on 5/20/16.
 */
public class ReverseBits {
    public static void main(String[] args) {
        System.out.println(IntToBit.intToBit(43261596));
        System.out.println(IntToBit.intToBit(964176192));
        System.out.println(reverseBits(43261596));
    }

    /**
     * https://leetcode.com/discuss/97347/sharing-my-2ms-java-solution-with-explanation
     * @param n
     * @return
     */
    public static int reverseBits(int n) {
       /* int res = 0;
        for (int i = 0; i < 32; i++) {
            res = res << 1;
            if ((n & 1) == 1) {
                res++;
            }
            n = n >> 1;
        }
        return res;*/
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int bit = (n >> i) & 1;
            res += bit << (31 - i);
        }
        return res;
    }
}
