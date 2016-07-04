/**
 * Created by thanksgiving on 7/3/16.
 */
public class TwoColorSort {
    public static void main(String[] args) {
        int[] a = {-9, 1, 8, -1, 7, 13, -20, -5, 3};
        sort(a);
        printArray(a);
    }

    public static void sort(int[] a) {
        int l = 0, r = a.length - 1;
        while (l <= r) {
            if (a[l] <= 0) {
                l++;
            } else {
                while (l <= r && a[r] > 0) {
                    r--;
                }
                if (l <= r)
                    swap(a, l, r);
            }
        }
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
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
