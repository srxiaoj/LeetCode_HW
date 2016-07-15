/**
 * Created by thanksgiving on 7/13/16.
 */
public class ClosestNumberInSortArray {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 3, 3, 3, 7, 8, 10, 100};
        System.out.println(findClosestVal(a, 6));
        int[] b = {4, 9, 11};
        System.out.println(findClosestVal(b, 12));
    }

    public static int findClosestVal(int[] a, int target) {
        int l = 0, r = a.length - 1;
        while (l + 1 < r) {
            int mid = l + (r - l) / 2;
            if (a[mid] == target) {
                return target;
            } else if (a[mid] < target) {
                l = mid;
            } else {
                r = mid;
            }
        }
        System.out.println("l: " + a[l] + " r: " + a[r]);
        if (Math.abs(target - a[l]) <= Math.abs(a[r] - target)) {
            return a[l];
        } else {
            return a[r];
        }
    }
}
