/**
 * Created by thanksgiving on 7/14/16.
 */
public class IncreasingTripletSubsequenceII {
    public static void main(String[] args) {
        int[] a = {7, 4, 5, 2, 8};
        int[] res = getThreeElement(a);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
        System.out.println();

        int[] b = {1, 6, 5, 2, 8};
        int[] res2 = getThreeElement(b);
        for (int i = 0; i < res2.length; i++) {
            System.out.print(res2[i] + " ");
        }
    }

    public static int[] getThreeElement(int[] a) {
        int first = Integer.MAX_VALUE, second = Integer.MAX_VALUE;
        int third = 0;
        int[] res = new int[3];
        int j = 0;

        for (int i = 0; i < a.length; i++) {
            if (a[i] > second) {
                third = a[i];
                j = i;
                break;
            } else if (a[i] > first) {
                second = a[i];
            } else {
                first = a[i];
            }
        }
        res[2] = third;
        res[0] = Integer.MAX_VALUE;
        res[1] = Integer.MAX_VALUE;
        for (int i = j - 1; j >= 0; i--) {
            if (a[i] < res[1] && res[1] != Integer.MAX_VALUE) {
                res[0] = a[i];
                return res;
            } else if (a[i] < res[2]) {
                res[1] = a[i];
            } else {
                res[0] = a[i];
            }
        }
        return res;
    }
}
