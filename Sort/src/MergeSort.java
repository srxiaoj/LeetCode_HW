public class MergeSort {
    public static void main(String[] args) {
        int[] test = new int[] {8,2,1,9,4,10,18,3};
        mergeSort(test, 0, test.length-1);
        printArray(test);

    }
    /* l is for left index and r is right index of the sub-array
    of arr to be sorted */
    private static void mergeSort(int[] a, int l, int r) {
        if (l < r) {
            int mid = l+(r-l)/2;//same as (l+r)/2, but avoids overflow for large l and h
            mergeSort(a, l, mid);
            mergeSort(a, mid+1, r);
            merge(a, l, mid, r);
        }
    }
    private static void merge(int[] a, int l, int mid, int r) {
        int i, j, k;
        int n1 = mid-l+1;
        int n2 = r-mid;
        
        /*create temp arrays*/
        int[] L = new int[n1];
        int[] R = new int[n2];
        /*copy data to temp arrays*/
        for (i = 0; i < n1; i++) {
            L[i] = a[l+i];
        }
        for (j = 0; j < n2; j++) {
            R[j] = a[mid+1+j];
        }
        /*merge the temp arrays back into a[l..r]*/
        i = 0;
        j = 0;
        k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                a[k] = L[i];
                i++;
            } else {
                a[k] = R[j];
                j++;
            }
            k++;
        }
        /*copy the remaining elements of L[], if there are any*/
        while (i < n1) {
            a[k] = L[i];
            i++;
            k++;
        }
        /*copy the remaining elements of R[], if there are any*/
        while (j < n2) {
            a[k] = R[j];
            j++;
            k++;
        }
        
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