import java.util.ArrayList;
import java.util.List;

/**
 * Created by thanksgiving on 12/27/15.
 */
public class PermutationSequence {
    public static void main(String[] args) {
        PermutationSequence obj = new PermutationSequence();
        System.out.println(obj.getPermutation(9, 54494));
    }

    public String getPermutation(int n, int k) {
        int pos = 0;
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
        for (int i = 1; i <= n; i++) {
            numbers.add(i);
        }
        // numbers = {1, 2, 3, 4}

        k--;

        for (int i = 1; i <= n; i++) {
            int index = k / factorial[n - i];
            sb.append(String.valueOf(numbers.get(index)));
            numbers.remove(index);
            k -= index * factorial[n - i];
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
