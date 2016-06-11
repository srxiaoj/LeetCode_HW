/**
 * Created by thanksgiving on 6/10/16.
 */
public class Merge {
    public static void main(String[] args) {
        int[] num = {4, 7, 1, 8, 5, 3, 2};
        mergesort(num);
        printArray(num);
    }

    private static void mergesort(int[] num) {
        int[] res = split(num, 0, num.length - 1);
        printArray(res);
        num = res;
        return;
    }

    private static int[] split(int[] num, int l, int r) {
        if (l >= r) return num;
        int mid = l + (r - l) / 2;
        int[] left = split(num, l, mid);
        int[] right = split(num, mid + 1, r);
        int[] res = merge(left, right);
        return res;
    }

    private static int[] merge(int[] a, int[] b) {
        int i = 0, j = 0, k = 0;
        int[] c = new int[a.length + b.length];
        while (i < a.length || j < b.length) {
            if (i < a.length && j < b.length) {
                if (a[i] < b[j]) {
                    c[k] = a[i];
                    i++;
                } else {
                    c[k] = b[j];
                    j++;
                }
            } else if (i < a.length) {
                c[k] = a[i];
                i++;
            } else {
                c[k] = b[j];
                j++;
            }
            k++;
        }
        return c;
    }

    //print array
    public static void printArray(int[] A) {
        for (int i = 0; i < A.length; i++) {
            if (i != A.length - 1)
                System.out.print(A[i] + ", ");
            else
                System.out.print(A[i]);
        }
        System.out.println("");
    }
}
