import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/10/12.
 */
public class ReorderArray {
    public static void main(String[] args) {
        printArray(reorder(new int[] {0, 1, 2, 1, 0}));
    }

    public static int[] reorder(int[] a) {
        if (a == null || a.length == 0) return new int[0];
        int n = a.length;
        int[] b = new int[n];
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);//1,2,3,4,5
        }
        for (int i = n - 1; i >= 0; i--) {
            b[i] = list.remove(i - a[i]);
        }

        return b;
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
