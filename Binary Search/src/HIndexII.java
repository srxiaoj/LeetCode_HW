import java.util.Arrays;


public class HIndexII {
    public static void main(String[] args) {
        int test[] = new int[] {3,0,6,1,5};
        int test2[] = new int[] {3,3,3,1};
        System.out.println("The h index is: " + hIndex(test));
        System.out.println("The h index is: " + hIndex(test2));
    }
    public static int hIndex(int[] citations) {
        
        //Arrays.sort(citations);
        printArray(citations);
        if(citations.length == 0) return 0;
        int res = binarySearch(citations, 0, citations.length-1);
        return res;
        
        /*
        //O(n) complexity
        for(int i = 0; i < citations.length; i++) {
            //if the citation is higher than the number of papers with citation higher than this number
            if(citations[i] >= citations.length - i) return citations.length - i;
        }
        return 0;
        */
    }
    private static int binarySearch(int [] c, int l, int r) {
        while (l <= r) {
            int mid = (l+r)/2;
            if (c[mid] == c.length - mid) {//citation h index is too high
                return c.length - mid;
            } else if (c[mid] < c.length - mid) {
                l = mid + 1;
            } else {
                /*(citations[mid] > len-mid), mid qualified as a hIndex,
                   but we have to continue to search for a higher one. */
                r = mid - 1;
            }
        }
        return c.length - l;
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
