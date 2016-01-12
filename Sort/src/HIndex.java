import java.util.Arrays;

public class HIndex {
    public static void main(String[] args) {
        int test[] = new int[] {7,1,4,5,6};
        System.out.println("The h index is: " + hIndex(test));
    }
    public static int hIndex(int[] citations) {
        if(citations.length == 0) return 0;
        sort(citations);
        int h = 0;
        while (h < citations.length && h+1 <= citations[h]) {
            h++;
        }
        return h;
    }
    /*descendent sort*/
    private static void sort(int[] a) {
        Arrays.sort(a);
        int[] tmp = new int[a.length];
        for(int i = 0; i < a.length; i++){
            tmp[i] = a[i];
        }
        for(int i = 0; i < a.length; i++) {
            a[i] = tmp[a.length-1-i];
        }
        printArray(a);
    }
    //print array
    public static void printArray(int [] A)
    {
        for(int i = 0; i < A.length; i++)
        {
            System.out.print(A[i] + " ");
        }
        System.out.println(" ");
    }
}