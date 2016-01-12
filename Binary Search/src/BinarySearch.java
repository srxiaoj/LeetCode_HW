/**
 * Basic binary search, nonrecursive
 * return position if target is found
 * otherwise return the index it should be inserted
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] test = new int[] {1,2,3,4,5,6};
        int target = 8;
        System.out.println(BinarySearch(test, target, 0, test.length-1));
    }
    public static int BinarySearch(int[] array, int k, int l, int r) {
        
        while (l <= r) {// <= is essential, for case like there is only one element
            int mid = (l+r)/2;
            if (array[mid] == k){
                return mid;
            } else if (array[mid] > k) {
                r = mid - 1;
            } else if (array[mid] < k) {
                l = mid + 1;
            }
        }
        if (k > array[array.length-1])
            return l;
        return r;//if none is found
    }
}