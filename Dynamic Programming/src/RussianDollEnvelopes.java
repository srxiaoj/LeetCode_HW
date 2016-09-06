import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by thanksgiving on 9/5/16.
 */
public class RussianDollEnvelopes {
    public static void main(String[] args) {
//        int[][] envelops = {{7,8},{12,16},{12,5},{1,8},{4,19},{3,15},{4,10},{9,16}};
//        int[][] envelops = {{1, 1},{1, 1},{1, 1}};
//        int[][] envelops = {{5, 4},{6, 4},{6, 7},{2, 3}};
//        int[][] envelops = {{6, 4},{6, 7},{2, 3}};
        int[][] envelops = {{2,100},{3,200},{4,300},{5,500},{5,400},{5,250},{6,370},{6,360},{7,380}};
//        int[][] envelops = {{2,100},{2,200},{2,300},{2,500},{2,400},{2,250},{2,370},{2,360},{2,380}};
        System.out.println(maxEnvelopes(envelops));
    }

    /**
     * 排序时候注意要排序为 [2, 100][3, 200][4, 300][5, 500][5, 400][5, 250][6, 370][6, 360][7, 380]
     */
    public static int maxEnvelopes(int[][] envelopes) {
        if(envelopes == null || envelopes.length == 0 || envelopes[0] == null || envelopes[0].length != 2)
            return 0;
        Arrays.sort(envelopes, new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                if(a[0] == b[0]) return b[1] - a[1];
                return a[0] - b[0];
            }
        });
        printArray(envelopes);

        int dp[] = new int[envelopes.length];
        dp[0] = envelopes[0][1];
        int len = 0;
        int pos = 0;
        for(int i = 1; i < envelopes.length; i++){
            pos = binarySearch(dp, 0, len, envelopes[i][1]);
            dp[pos] = envelopes[i][1];
            if(pos > len) len++;

            printArray(dp);
        }
        return len + 1;
    }

    private static int binarySearch(int[] res, int start, int end, int t) {
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (res[mid] > t) {
                end = mid;
            } else {
                start = mid;
            }
        }

        if (res[end] < t) {
            return end + 1;
        } else if (res[start] >= t) {
            return start;
        } else {
            return start + 1;
        }
    }


    public static int maxEnvelopesDP(int[][] envelopes) {
        if (envelopes.length == 0) return 0;
        int n = envelopes.length;
        if (n == 1) return 1;
        Arrays.sort(envelopes, new MyComparator());
        printArray(envelopes);

        int[] dp = new int[n];
        int max = 1;
        Arrays.fill(dp, 1);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    max = Math.max(dp[i], max);
                }
            }
        }
        return max;
    }

    public static class MyComparator implements Comparator<int[]> {
        public int compare(int[] a, int[] b) {
            if (a[0] == b[0]) return b[1] - b[0];
            return a[0] - b[0];
        }
    }

    /**
     * print 2D array.
     */
    public static void printArray(int[][] A) {
        for (int i = 0; i < A.length; i++) {
            System.out.print("[");
            for (int j = 0; j < A[i].length; j++) {
                if (j != A[i].length - 1) {
                    System.out.print(A[i][j] + ", ");
                } else
                    System.out.print(A[i][j]);

            }
            System.out.print("]");
        }
        System.out.println("");
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
