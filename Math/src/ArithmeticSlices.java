/**
 * Created by Administrator on 2016/10/21.
 */
public class ArithmeticSlices {
    public static void main(String[] args) {
        System.out.println(numberOfArithmeticSlices(new int[] {1, 2, 3, 4, 6, 8, 10}));
    }

    public static int numberOfArithmeticSlices(int[] A) {
        int sum = 0, count = 2;
        int n = A.length;
        if (n < 3) return 0;
        int diff = A[1] - A[0];
        for (int i = 2; i < n; i++) {
            if (A[i] - A[i - 1] == diff) {
                count++;
            } else {
                if (count >= 3) {
                    for (int j = 3; j <= count; j++) {
                        sum += count - j + 1;
                    }
                }
                count = 2;
                diff = A[i] - A[i - 1];
            }
        }
        if (count >= 3) {
            for (int j = 3; j <= count; j++) {
                sum += count - j + 1;
            }
        }

        return sum;
    }
}
