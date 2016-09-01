/**
 * Created by thanksgiving on 7/18/16.
 */
public class RangeAddition {
    public static void main(String[] args) {
        int[][] updates = {
                {1, 3, 2},
                {2, 4, 3},
                {0, 2, -2}
        };
        printArray(getModifiedArray(5, updates));
    }

    public static int[] getModifiedArray(int length, int[][] updates) {
        int[] res = new int[length];
        for (int[] sub : updates) {
            res[sub[1]] += sub[2];
            if (sub[0] > 0) {
                res[sub[0] - 1] -= sub[2];
            }
            printArray(res);
        }

        for (int i = length - 2; i >= 0; i--) {
            res[i] += res[i + 1];
        }
        return res;
    }

    //print array
    public static void printArray(int[] A) {
        System.out.print("[");
        for (int i = 0; i < A.length; i++) {
            if (i != A.length - 1)
                System.out.print(A[i] + ", ");
            else
                System.out.print(A[i]);
        }
        System.out.println("]");
    }
}
