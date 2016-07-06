/**
 * Created by thanksgiving on 7/5/16.
 */
public class FindMaxInAscDescArray {
    public static void main(String[] args) {
        System.out.println(findPeak(new int[]{3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 5, 10, 12, 9, 5, 3, 2}));
        System.out.println(findPeak(new int[]{1, 2, 3, 5, 4, 4, 4, 4, 4, 4, 4, 4}));
    }

    public static int findPeak(int[] a) {
        int l = 0, r = a.length - 1;
        while (l + 1 < r) {
            int mid = l + (r - l) / 2;
            if (a[mid] > a[mid - 1] && a[mid] > a[mid + 1]) return a[mid];
            if (a[mid] > a[mid - 1] && a[mid] < a[mid + 1]) {
                l = mid;
            } else if (a[mid] < a[mid - 1] && a[mid] > a[mid + 1]) {
                r = mid;
            } else if (a[mid] == a[mid + 1] || a[mid - 1] == a[mid]) {
                int start, end, temp = mid;
                while (mid < r && a[mid] == a[mid + 1]) {
                    mid++;
                }
                end = mid;
                mid = temp;
                while (mid > l && a[mid] == a[mid - 1]) {
                    mid--;
                }
                start = mid - 1;

                if (start < 0 || a[start] < a[end]) {
                    l = end;
                } else {
                    r = start;
                }
            }
        }
        return Math.max(a[l], a[r]);
    }
}
