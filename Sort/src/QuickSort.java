/**
 * This algorithm implements the quicksort algorithm.
 * @author Haorui Wu
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] test = {139, 54, 25, 61, 17, 8, 9, 1, 982, 918, 11, 9, 7, 6};
        quicksort(test, 0, test.length-1);
        printArray(test);
    }

    public static void quicksort(int[] array, int l, int r) {
        int pivot;
        if (l < r) {
            pivot = partition(array, l, r);
            quicksort(array, l, pivot - 1);
            quicksort(array, pivot + 1, r);
        }
    }
    /**
     * use first index as initial pivot.
     * sorted in descendent sequence
     */
    private static int partition(int[] array, int l, int r) {
        int p = l;
        int pValue = array[l];
        for (int i = l + 1; i <= r; i++) {
            if (array[i] > pValue) {
                p++;
                swap(array, i, p);
            }
        }

        // since l is the last index that is larger than p
        // swap l and p means all elements before p is larger than pivot
        swap(array, p, l);
        return p;
    }
    private static void swap(int[] array, int a, int b) {
        int temp = array[a]; 
        array[a] = array[b];
        array[b] = temp;
    }
    //print array
    public static void printArray(int[] A)
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