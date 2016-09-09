import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by thanksgiving on 7/7/16.
 */
public class LargestDoubleInterval {
    public static void main(String[] args) {
        double[] a = new double[]{2.7, 0.23, 8.32, 9.65, -6.55, 1.55, 1.98, 7.11, 0.49, 2.75, 2.95, -96.023, 0.14, 8.60};
        System.out.println(largestDoubleInterval(a));
    }

    public static int largestDoubleInterval(double[] a) {
        List<Double> list;
        List<Double> maxList = new ArrayList<>();
        double val = a[0];
        Arrays.sort(a);
        int max = 0, j;
        for (int i = 0; i < a.length; i++) {
            j = i + 1;
            list = new ArrayList<>();
            while (j < a.length && a[j] < a[i] + 1) {
                list.add(a[j]);
                if (max < j - i + 1) {
                    max = j - i + 1;
                    maxList = new ArrayList<>(list);
                    val = a[i];
                }
                j++;
            }
        }
        maxList.add(0, val);
        System.out.println(maxList);
        System.out.println(val);
        return max;
    }
}
