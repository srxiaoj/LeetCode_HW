/**
 * Created by thanksgiving on 6/10/16.
 */
public class Mergesort {
    public static void main(String[] args) {
        int[] num = {4, 7, 1, 8, 5, 3, 2};
        mergesort(num);
        printArray(num);
    }

    private static void mergesort(int[] num) {
        mergesort(num, 0, num.length - 1);
        return;
    }

    private static void mergesort(int[] num, int l, int r) {
        if (l >= r) return;
        int mid = l + (r - l) / 2;
        mergesort(num, l, mid);
        mergesort(num, mid + 1, r);
        merge(num, l, mid, r);
    }

    private static void merge(int[] num, int l, int mid, int r) {
        int[] a = new int[mid - l + 1];
        int[] b = new int[r - mid];
        for (int i = 0; i < a.length; i++) {
            a[i] = num[l + i];
        }

        for (int j = 0; j < b.length; j++) {
            b[j] = num[mid + 1 + j];
        }

        // 注意 k 要从 l 开始
        int i = 0, j = 0, k = l;
        while (i < a.length && j < b.length) {
            if (a[i] < b[j]) {
                num[k] = a[i];
                i++;
            } else {
                num[k] = b[j];
                j++;
            }
            k++;
        }

        while (i < a.length) {
            num[k] = a[i];
            i++;
            k++;
        }

        while (j < b.length) {
            num[k] = b[j];
            j++;
            k++;
        }
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
