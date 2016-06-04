
public class sqrt {

    public static void main(String[] args) {
        //        System.out.println(mySqrt(13));
        System.out.println(mySqrt(2147395599));
        System.out.println(mySqrt(2147483647));
        System.out.println(mySqrt(16));
        // sqrt(2147483647) = 46340
        System.out.println(2147483647 / 46340);
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

    /**
     * mathematical method to get sqrt
     *
     * @param x
     * @return
     */
    public static double mySqrt(double x) {
        if (x == 0) return 0;
        double res = x / 2;
        double presRes = 0;
        while (res != presRes) {
            presRes = res;
            System.out.println("presRes is: " + presRes);
            res = (x / presRes + presRes) / 2;
            System.out.println("res is: " + res);

        }
        return res;
    }
}
