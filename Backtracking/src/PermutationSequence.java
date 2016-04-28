import java.util.ArrayList;
import java.util.List;

/**
 * Created by thanksgiving on 12/27/15.
 */
public class PermutationSequence {
  /*  public static void main(String args[] ) throws Exception {
    *//* Enter your code here. Read input from STDIN. Print output to STDOUT *//*
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] fields = input.split(" ");
        if (fields == null || fields.length != 2) return;
        long m = Long.parseLong(fields[0]);
        int n = Integer.parseInt(fields[1]);
//        m--;

        List<Integer> nums = new ArrayList<>();
        long[] factorial = new long[n + 1];
        factorial[0] = 1;
        StringBuilder sb = new StringBuilder();

        // pre compute the factorial map
        long product = 1;
        for (int i = 1; i < n + 1; i++) {
            product = product * i;
            factorial[i] = product;
        }
        for (int i = 0; i < n; i++) {
            nums.add(i);
        }
        for (int i = 1; i < n + 1; i++) {
            int index =  (int) m / (int) factorial[n - i];
            m -= index * factorial[n - i];
            int nextNum = nums.get(index);
            sb.append(String.valueOf(nextNum) + " ");
            nums.remove(index);
        }
        sb.delete(sb.length() - 1, sb.length());
        System.out.println(sb.toString());
    }*/

    public static void main(String[] args) {
        PermutationSequence obj = new PermutationSequence();
        System.out.println(obj.getPermutation(3, 4));
    }

    public String getPermutation(int n, int k) {
        List<Integer> numbers = new ArrayList<>();
        int[] factorial = new int[n + 1];
        StringBuilder sb = new StringBuilder();
        // create an array of factorial lookup
        // factorial[] = {1, 1, 2, 6, 24, ... n!}
        int sum = 1;
        factorial[0] = 1;
        for (int i = 1; i <= n; i++) {
            sum *= i;
            factorial[i] = sum;
        }

        // create a list of numbers to get indices
        // numbers = {1, 2, 3, 4}
        for (int i = 1; i <= n; i++) {
            numbers.add(i);
        }
        k--;
        for (int i = 1; i <= n; i++) {
            int index = k / factorial[n - i];
            sb.append(String.valueOf(numbers.get(index)));
            numbers.remove(index);
            k -= index * factorial[n - i];
        }
        return String.valueOf(sb);
    }
}
