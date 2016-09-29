/**
 * Created by thanksgiving on 9/28/16.
 */
public class MedianofTwoSortedArrays {
    public static void main(String[] args) {
//        System.out.println(findMedianSortedArrays(new int[] {1, 3}, new int[] {2}));
//        System.out.println(findMedianSortedArrays(new int[] {1, 2}, new int[] {3, 4}));
        System.out.println(findMedianSortedArrays(new int[] {3, 10}, new int[] {1, 2, 4, 5, 6, 7, 8, 9}));
    }


    /**
     * https://discuss.leetcode.com/topic/4996/share-my-o-log-min-m-n-solution-with-explanation/27
     * A[0 ..... i - 1]   A[i .... m]
     * B[0 ..... j - 1]   B[j .... n]
     * i + j == m - i + 1 + n - j + 1
     * j == (m + n + 1) / 2 - i
     *
     * B[j - 1] <= A[i] && A[i - 1] <= B[j]
     */
    public static double findMedianSortedArrays(int[] A, int[] B) {
        int m = A.length, n = B.length;
        if (m > n) return findMedianSortedArrays(B, A);
        int iStart = 0, iEnd = m, totalLen = (m + n + 1) >> 1;
        while (iStart <= iEnd) {
//            int iMid = iStart + (iEnd - iStart) / 2;
            int iMid = (iStart + iEnd) >> 1;
            int jMid = totalLen - iMid;

            if (jMid > 0 && iMid < m && B[jMid - 1] > A[iMid]) {
                iStart = iMid + 1;
            } else if (jMid < n && iMid > 0 && A[iMid - 1] > B[jMid]) {
                iEnd = iMid - 1;
            } else { // (A[iMid - 1] <= B[jMid] && B[jMid - 1] <= A[iMid])
                int leftMax;
                if (iMid == 0) { // all element in A larger than element in B
                    leftMax = B[jMid - 1];
                } else if (jMid == 0) {
                    leftMax = A[iMid - 1]; // all element in B larger than element in A
                } else {
                    leftMax = Math.max(A[iMid - 1], B[jMid - 1]);
                }
                System.out.println(leftMax);
                if ((m + n) % 2 != 0) {
                    return (double) leftMax;
                }

                int rightMin;
                if (iMid == m) {
                    rightMin = B[jMid];
                } else if (jMid == n) {
                    rightMin = A[iMid];
                } else {
                    rightMin = Math.min(A[iMid], B[jMid]);
                }
                System.out.println(rightMin);
                return (double) ((leftMax + rightMin) / 2.0);
            }
        }

        return 0;
    }
}