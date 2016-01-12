import java.util.ArrayList;

/**
 * Created by thanksgiving on 1/9/16.
 */
public class ContinuousSubarraySumII {
    public static void main(String[] args) {
        ContinuousSubarraySumII obj = new ContinuousSubarraySumII();
        int[] a = {-1, 100, -2, -5, 3};
        System.out.println("result is: " + obj.continuousSubarraySum(a));

        int[] b = {3, 1, -100, -3, 4};
        System.out.println("result is: " + obj.continuousSubarraySum(b));

        int[] c = {1,2,-2,-100,1,2,-2};
        System.out.println("result is: " + obj.continuousSubarraySum(c));
    }

    public ArrayList<Integer> continuousSubarraySum(int[] a) {
        // Write your code here
        int start = 0, end = 0, startCandidate = 0;
        int n = a.length;
        int[] array = new int[n + n - 1];
        for (int i = 0; i < n; i++) {
            array[i] = a[i];
        }
        for (int i = n; i < array.length; i++) {
            array[i] = a[i - n];
        }
        int minSum = 0;
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n + n - 1; i++) {
            if (i - start > n - 1) {
//                sum -= array[start];
                if (minSum > sum - array[i])
                    minSum = sum - array[i];
            }
            if (minSum > sum) {
                minSum = sum;
                startCandidate = i;
            }
            sum += array[i];
            if (sum - minSum > max) {
                max = sum - minSum;
                end = i;
            }
            if (startCandidate <= end) {
                start =  startCandidate;
            }
        }
        // System.out.println("start is: " + start);
        // System.out.println("end is: " + end);
         System.out.println("max is: " + max);
        ArrayList<Integer> list = new ArrayList<>();
        list.add(start);
        list.add(end);
        return list;

        /*
        if (a.length == 0) return new ArrayList<>();
        int start = 0, end = 0;
        int n = a.length;
        int[] array = new int[n + n - 1];
        for (int i = 0; i < n; i++) {
            array[i] = a[i];
        }
        for (int i = n; i < array.length; i++) {
            array[i] = a[i - n];
        }
        int total = 0, max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            total = 0;
            for (int j = i; j < i + n; j++) {
                total += array[j];
                if (total > max) {
                    max = total;
                    start = i;
                    end = j;
                }
            }
        }
        if (end > n) {
            end -= n;
        }
//        System.out.println("start is: " + start);
//        System.out.println("end is: " + end);
        ArrayList<Integer> list = new ArrayList<>();
        list.add(start);
        list.add(end);
        return list;
        */
    }
}
