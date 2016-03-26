import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by thanksgiving on 12/27/15.
 */
public class PermutationSequence {
    public static void main(String args[] ) throws Exception {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */
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
    }

//    public static void main(String[] args) {
//        PermutationSequence obj = new PermutationSequence();
//        System.out.println(obj.getPermutation(3, 6));
//    }

    public String getPermutation(int n, int k) {
        List<Integer> numbers = new ArrayList<>();
        int[] factorial = new int[n + 1];
        StringBuilder sb = new StringBuilder();

        // create an array of factorial lookup
        int sum = 1;
        factorial[0] = 1;
        for (int i = 1; i <= n; i++) {
            sum *= i;
            factorial[i] = sum;
        }
        // factorial[] = {1, 1, 2, 6, 24, ... n!}

        // create a list of numbers to get indices
        for (int i = 0; i < n; i++) {
            numbers.add(i);
        }
        // numbers = {0, 1, 2, 3}

        k--;

        for (int i = 1; i <= n; i++) {
            int index = k / factorial[n - i];
            k -= index * factorial[n - i];
            sb.append(String.valueOf(numbers.get(index)));
            numbers.remove(index);
        }

        return String.valueOf(sb);
        /*
        //method 2
        int[] numPer = {1, 2, 6, 24, 120, 720, 5040, 40320};
        LinkedList<Integer> myList = new LinkedList<Integer>();
        for (int i = 1; i <= n; i++)
            myList.add(i);
        char[] res = new char[n];
        for (int i = n - 2; i >= 0; i--) {
            int num = (k - 1) / numPer[i];
            res[n - 2 - i] = (char) (myList.get(num) + '0');
            myList.remove(num);
            k = k % numPer[i] == 0 ? numPer[i] : k % numPer[i];
        }
        res[n - 1] = (char) (myList.get(0) + '0');
        return new String(res);
        */

        /*
        if (n == 0) return null;
        return permute(n).get(k - 1);
        */

    }

    public List<String> permute(int n) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(String.valueOf(i + 1));
        }
        for (int i = 0; i < n; i++) {
            List<String> newList = new ArrayList<>();
            for (String s : list) {
                for (int j = 0; j < n; j++) {
                    if (!s.contains(String.valueOf(j + 1))) {
                        newList.add(s + String.valueOf(j + 1));
                    }
                }
            }
            if (newList.size() != 0) {
                list = new ArrayList<>(newList);
            }
        }
        return list;
    }

//    private boolean hasString(String a, int num) {
//        for (int i = 0; i < a.length(); i++) {
//            int val = Character.getNumericValue(a.charAt(i));
//            if (val == num) {
//                return true;
//            }
//        }
//        return false;
//    }
}
