public class HIndexII {
    public static void main(String[] args) {
        int test[] = new int[]{0, 4, 6, 7, 8};
        System.out.println("The h index is: " + hIndex(test));
    }

    public static int hIndex(int[] citations) {
        // wrong solution
       /* int n = citations.length;
        int start = 0, end = n - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (citations[mid] == n - mid) {
                return citations[mid];
            } else if (citations[mid] > n - mid) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (citations[end] == n - end) {
            return end;
        } else {
            return start;
        }*/


        int n = citations.length;
        int lo = 0, hi = n - 1;
        while (lo <= hi) {
            int mid = (hi + lo) / 2;
            if (citations[mid] == n - mid) {
                return n - mid;
            } else if (citations[mid] < n - mid) {
                lo = mid + 1;
            } else {
                //(citations[mid] > n-mid), mid qualified as a hIndex,
                // but we have to continue to search for a higher one.
                hi = mid - 1;
            }
        }
        return n - lo;
    }
}