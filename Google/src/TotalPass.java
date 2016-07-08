import java.util.Arrays;

/**
 * Created by thanksgiving on 7/7/16.
 */
public class TotalPass {
    public static void main(String[] args) {
        int[] a = {3, 1, 4, 0, 2, 5, 5, 9, 10};
        System.out.println(findTotalPass(a));
    }

    public static int findTotalPass(int[] a) {
        Arrays.sort(a);
        int sum = 0, lastIndex = a.length;
        for (int i = a.length - 1; i > 0; i--) {
            if (a[i - 1] == a[i]) {
                sum += a.length - lastIndex;
            } else {
                sum += a.length - lastIndex;
                lastIndex = i;
            }
        }
        // add the first point
        sum += a.length - lastIndex;
        return sum;
    }
}
