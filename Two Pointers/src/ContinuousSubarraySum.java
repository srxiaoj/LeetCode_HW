import java.util.ArrayList;

/**
 * Created by thanksgiving on 1/9/16.
 */
public class ContinuousSubarraySum {
    public static void main(String[] args) {
        ContinuousSubarraySum obj = new ContinuousSubarraySum();
//        int[] a = {1, -1};
//        System.out.println(obj.continuousSubarraySum(a));
////
//        int[] b = {-3, 1, 3, -3, 4};
//        System.out.println(obj.continuousSubarraySum(b));

        int[] c = {-8, -3, -1, -5, -10, -2};
        System.out.println(obj.continuousSubarraySum(c));
    }

    public ArrayList<Integer> continuousSubarraySum(int[] a) {

        int start = 0, end = 0, startCandidate = 0;
        int n = a.length;
        int minSum = 0;
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            // use minSum to represent the minimum total value before i
            // if sum is smaller than previous minimum sum, update new start point
            if (minSum > sum) {
                minSum = sum;
                startCandidate = i;
            }
            sum += a[i];
            if (sum - minSum > max) {
                max = sum - minSum;
                end = i;
            }
            // since its possible that startCandidate will be larger than end
            // for each loop index, we need to make sure that start < end
            if (startCandidate <= end) {
                start =  startCandidate;
            }
        }

        // System.out.println("start is: " + start);
        // System.out.println("end is: " + end);
        ArrayList<Integer> list = new ArrayList<>();
        list.add(start);
        list.add(end);
        return list;

        /*
        int start = 0, end = 0;
        int n = a.length;
        int total = 0, max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            total = 0;
            for (int j = i; j < n; j++) {
                total += a[j];
                if (total > max) {
                    max = total;
                    start = i;
                    end = j;
                }
            }
        }
        System.out.println("start is: " + start);
        System.out.println("end is: " + end);
        return max;
        */
    }
}
