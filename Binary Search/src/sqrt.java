/**
 * Created by thanksgiving on 3/26/16.
 */
public class sqrt {

    public static void main(String[] args) {
        System.out.println(mySqrt(13));
        System.out.println(mySqrt(2147395599));
        System.out.println(mySqrt(2147483647));
        System.out.println(mySqrt(16));
    }
    public static int mySqrt(int x) {
        int start = 0;
        int end = x;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (mid == x / mid) {
                return mid;
            }
            if (mid > x / mid) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (end != 0 && end > x / end) {
            return start;
        } else {
            return end;
        }
    }
}
