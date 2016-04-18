/**
 * Created by thanksgiving on 4/18/16.
 */
public class CountingBits {
    public static void main(String[] args) {
        CountingBits obj = new CountingBits();
        int[] res = obj.countBits(16);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }

    }

    /**
     * 所有为2的倍数count都为0
     * 其余则为n[num - 上一个最大的2的倍数] + 1
     * n[1] = 1
     * n[2] = 1
     * n[3] = n[3 - 2] + 1
     * n[4] = 1
     * n[5] = n[5 - 4] + 1
     * n[6] = n[6 - 4] + 1
     * n[7] = n[7 - 4] + 1
     * n[8] = 1
     * n[9] = n[9 - 8] + 1
     * @param num
     * @return
     */
    public int[] countBits(int num) {
        int[] res = new int[num + 1];
        int offset = 0;
        int nextMultipleOfTWO = 1;

        for (int i = 1; i <= num; i++) {
            if (i == nextMultipleOfTWO) {
                res[i] = 1;
                offset = nextMultipleOfTWO;
                nextMultipleOfTWO = 2 * nextMultipleOfTWO;
            } else {
                res[i] = 1 + res[i - offset];
            }
        }
        return res;
    }
}
