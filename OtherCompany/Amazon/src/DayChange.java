/**
 * Created by Administrator on 2016/10/10.
 */
public class DayChange {
    public static void main(String[] args) {
        int[] days = new int[] {1, 2, 3, 4, 5, 6, 7, 8};
        printArray(dayChange(days, 3));
    }

    public static int[] dayChange(int[] days, int n) {
        if (days == null || days.length == 0 || n <= 0) {
            return days;
        }
        for (int i = 0; i < n; i++) {
            int pre = 0;
            for (int j = 0; j < days.length - 1; j++) {
                int cur = days[j];
                days[j] = pre == days[j + 1] ? 0 : 1;
                pre = cur;
            }
            days[days.length - 1] = pre == 0 ? 0 : 1;
        }
        return days;
    }

    //print array
    public static void printArray(int[] A) {
        System.out.print("[");
        for (int i = 0; i < A.length; i++) {
            if (i != A.length - 1)
                System.out.print(A[i] + ", ");
            else
                System.out.print(A[i]);
        }
        System.out.println("]");
    }
}
