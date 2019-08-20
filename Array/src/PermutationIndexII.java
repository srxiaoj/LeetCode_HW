import java.util.*;

/**
 * Created by thanksgiving on 7/11/16.
 */
public class PermutationIndexII {
    public static void main(String[] args) {
//        System.out.println(permutationIndexII(new int[] {1, 4, 2, 2}));
//        System.out.println(permutationIndexII(new int[] {3, 2, 2, 1, 1}));
        System.out.println(permutationIndexII(new int[] {10,10,10,10,9,8,7,6,5,4,3,2,1}));
    }

    /**
     *
     0
     1
     5
     23
     119
     719
     5039
     40319
     362879
     3628799
     19958399
     79833599
     259459199
     259459200
     */
    public static long permutationIndexII2(int[] A) {
        long index = 0, fact = 1, dup = 1;
        Map<Integer, Integer> map = new java.util.HashMap<>();
        for (int i = A.length-1; i >= 0; i--) {
            if (!map.containsKey(A[i])) map.put(A[i], 1);
            else {
                map.put(A[i], map.get(A[i])+1);
                dup *= map.get(A[i]);
            }
            int rank = 0;
            for (int j = i+1; j < A.length; j++) {
                if (A[j] < A[i]) rank++;
            }
            index += rank * fact / dup;
            System.out.println(index);
            fact *= (A.length - i);
        }
        return index+1;
    }

    public static long permutationIndexII(int[] A) {
        // Write your code here
        List<Integer> list = new ArrayList<>();
        for (int a : A) {
            list.add(a);
        }
        Collections.sort(list);
        int n = A.length;

        long[] fac = new long[n + 1];
        fac[0] = 1;
        for (int i = 1; i <= n; i++) {
            fac[i] = fac[i - 1] * i;
        }

        Map<Integer, Integer> map = new java.util.HashMap<>();
        for (int a : A) {
            if (!map.containsKey(a)) {
                map.put(a, 1);
            } else {
                map.put(a, map.get(a) + 1);
            }
        }
        long res = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < list.size(); j++) {
                if (A[i] == list.get(j)) {
                    if (map.get(A[i]) == 1) {
                        map.remove(A[i]);
                    } else {
                        map.put(A[i], map.get(A[i]) - 1);
                    }
                    long duplicate = getDuplicate(map, fac, A[i]);
                    long dupliateInList = getDuplicateInList(map, A[i], fac);
//                    System.out.println(res);
                    res += fac[list.size() - 1] / duplicate * j / dupliateInList;
                    list.remove(j);
                    break;
                }
            }
        }
        return res + 1;
    }

    public static long getDuplicateInList(Map<Integer, Integer> map, int a, long[] fac) {
        long res = 1;
        if (map.containsKey(a)) {
            res *= fac[map.get(a) + 1];
        }
        return res;
    }

    public static long getDuplicate(Map<Integer, Integer> map, long[] fac, int a) {
        long res = 1;
        for (Integer key : map.keySet()) {
            if (map.get(key) > 1 && key != a) {
                res *= fac[map.get(key)];
            }
        }
        return res;
    }
}
