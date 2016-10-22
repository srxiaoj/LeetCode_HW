/**
 * Created by Administrator on 2016/10/22.
 */
public class LargestNumReplaceTwoDigitWithAverge {
    public static void main(String[] args) {
//        System.out.println(solution(12345)); // 2345
//        System.out.println(solution(345));   // 45
        System.out.println(solution(54321)); // 5432
//        System.out.println(solution(321));   // 32
//        System.out.println(solution(623315));// 63315
//        System.out.println(solution(1000000000));// 100000000
//        System.out.println(solution(10));// 1
//        System.out.println(solution(111234));// 11234
//        System.out.println(solution(4343434));
    }

    public static int solution(int X) {
        if (X < 10) return 0;
        String s = String.valueOf(X);
        int n = s.length();
        int[] num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = s.charAt(i) - '0';
        }
        int[] res = new int[n - 1];
        int i = 0, max = 0;
        while (i < n - 1) {
            res[i] = (int) Math.ceil((double) (num[i] + num[i + 1]) / 2.0);
            int j = i + 1;
            while (j < n - 1) {
                res[j] = num[j + 1];
                j++;
            }
            printArray(res);
            max = Math.max(max, getNum(res));
            for (j = 0; j <= i; j++) {
                res[j] = num[j];
            }
            i++;
        }
        return max;
    }

    private static int getNum(int[] num) {
        int sum = 0;
        for (int i = 0; i < num.length; i++) {
            sum = sum * 10 + num[i];
        }
        return sum;
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
