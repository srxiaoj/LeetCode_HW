/**
 * Created by thanksgiving on 12/30/15.
 */
public class InsertionSort {
    public static void main(String[] args) {
        InsertionSort obj = new InsertionSort();
        int[] a = {4, 5, 2, 1, 3};
        obj.insertionSort(a);
        printArray(a);
    }
    private void insertionSort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int tmp = a[i];
            int j = i - 1;
            while (j >= 0 && a[j] > tmp) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = tmp;
        }
    }
    //print array
    private static void printArray(int[] A)
    {
        for(int i = 0; i < A.length; i++)
        {
            if(i != A.length-1)
                System.out.print(A[i] + ", ");
            else
                System.out.print(A[i]);
        }
        System.out.println("");
    }
}
