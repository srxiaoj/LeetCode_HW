/**
 * Created by thanksgiving on 7/11/16.
 */
public class PermutationIndex {
    public static void main(String[] args) {
//        System.out.println(permutationIndex(new int[]{1, 2, 4}));
//        System.out.println(permutationIndex(new int[]{1, 4, 2}));
        System.out.println(permutationIndex(new int[]{2, 1, 4}));
        System.out.println(permutationIndex(new int[]{2, 4, 1}));
        System.out.println(permutationIndex(new int[]{4, 1, 2}));
        System.out.println(permutationIndex(new int[]{4, 2, 1}));
    }

    public static long permutationIndex(int[] A) {
        if (A == null || A.length == 0) return 0;
        long fac = 1, res = 0;
        for (int i = A.length - 1; i >= 0; i--) {
            int rank = 0;
            for (int j = i + 1; j < A.length; j++) {
                if (A[j] < A[i]) rank++;
            }
            res += rank * fac;
            fac *= (A.length - i);
        }
        return res + 1;
      /*  long res = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            list.add(A[i]);
        }
        Collections.sort(list);
        long[] fac = new long[A.length + 1];
        fac[0] = 1;
        for (int i = 1; i <= A.length; i++) {
            fac[i] = fac[i - 1] * i;
        }

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < list.size(); j++) {
                if (A[i] == list.get(j)) {
                    res += fac[list.size() - 1] * j;
                    list.remove(j);
                    break;
                }
            }
        }
        return res + 1;*/
    }
}
