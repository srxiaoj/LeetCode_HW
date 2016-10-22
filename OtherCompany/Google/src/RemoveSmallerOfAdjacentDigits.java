/**
 * find the smallest number that can be obtained from X by replacing two adjacent digits with larger
 * of the two.
 */
public class RemoveSmallerOfAdjacentDigits {
    public static void main(String[] args) {
        System.out.println(solution(233614)); // 23364
        System.out.println(solution(233641)); // 23361
        System.out.println(solution(123));    // 13
        System.out.println(solution(321));    // 31
        System.out.println(solution(213));    // 23
        System.out.println(solution(12));     // 2
        System.out.println(solution(1));      // 0
        System.out.println(solution(10));     // 1
        System.out.println(solution(100));    // 10
        System.out.println(solution(10001));  // 1001
        System.out.println(solution(100210)); // 10020
    }

    public static int solution(int X) {
        if (X < 10) return 0;
        String s = String.valueOf(X);
        int n = s.length();
        char[] num = new char[n];
        for (int i = 0; i < n; i++) {
            num[i] = s.charAt(i);
        }
        char[] res = new char[n - 1];
        res[0] = num[0];
        int i = 1, j = 1;
        while (i < n - 1) {
            if (num[i - 1] >= num[i] && num[i] > num[i + 1]) {
                i++;
                while (j < res.length) {
                    res[j++] = num[i++];
                }
                String total = new String(res);
                return Integer.parseInt(total);
            }
            res[j++] = num[i++];
        }
        i--;
        j--;
        if (j == i) {
            if (num[i] > num[i + 1]) {
                res[j] = num[i];
            } else {
                res[j] = num[i + 1];
            }
        }

        String total = new String(res);
        return Integer.parseInt(total);
    }
}
