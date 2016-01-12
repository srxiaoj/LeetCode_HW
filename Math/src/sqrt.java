
public class sqrt {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        double test = 25;
        System.out.println(mySqrt(test));
    }
    public static int mySqrt(int x) {
        if (x == 0) return 0;
        int left = 1;//left pointer
        int right = x;//right pointer
        int ans = 0;
        while (left <= right) {//converge condition
            int mid = left + (right - left) / 2;
            if (mid <= x / mid) {//verifying correct ans
                left = mid + 1;
                ans = mid;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }
    /**
     * mathematical method to get sqrt
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
            res = (x/presRes + presRes) / 2;
            System.out.println("res is: " + res);
            
        }
        return res;
    }
}
