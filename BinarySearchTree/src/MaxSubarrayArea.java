/**
 * Given a 2D array, find the maximum sum subarray in it
 */
class MaxSubarrayArea {
    public static void main(String[] args) throws java.lang.Exception {
        findMaxSubMatrix(new int[][]{
                {5, 2, 3},
                {-4, -2, 3},
                {1, 9, 7}
        });
    }

    /**
     * 求sub array 最大sum
     * 并且输出start, end - > [max, start, end]
     */
    public static int[] kadane(int[] a) {
        int[] result = new int[]{a[0], 0, 0};
        int localMax = a[0];
        int start = 0;
        for (int i = 1; i < a.length; i++) {
            if (localMax < 0) {
                localMax = a[i];
                start = i;
            } else {
                localMax += a[i];
            }
            if (result[0] < localMax) {
                result[0] = localMax;
                result[1] = start;
                result[2] = i;
            }
        }
        return result;
    }

    /**
     * To find and print maxSum, (left, top),(right, bottom)
     */
    public static void findMaxSubMatrix(int[][] a) {
        int cols = a[0].length;
        int rows = a.length;
        int[] currentResult;
        int maxSum = Integer.MIN_VALUE;
        int left = 0;
        int top = 0;
        int right = 0;
        int bottom = 0;

        for (int i = 0; i < rows; i++) {
            int[] tmp = new int[cols];
            for (int j = i; j < rows; j++) {
                for (int k = 0; k < cols; k++) {
                    tmp[k] += a[j][k];
                }
                System.out.println("start row : " + i + ", " + "end row: " + j);
                printArray(tmp);
                currentResult = kadane(tmp);
                if (currentResult[0] > maxSum) {
                    maxSum = currentResult[0];
                    top = i;
                    bottom = j;
                    left = currentResult[1];
                    right = currentResult[2];
                }
            }
        }



       /* for (int leftCol = 0; leftCol < cols; leftCol++) {
            int[] tmp = new int[rows];

            for (int rightCol = leftCol; rightCol < cols; rightCol++) {

                for (int i = 0; i < rows; i++) {
                    tmp[i] += a[i][rightCol];
                }
//                System.out.println("leftCol: " + leftCol + ", " + "rightCol: " + rightCol);
//                printArray(tmp);
                currentResult = kadane(tmp);
                if (currentResult[0] > maxSum) {
                    maxSum = currentResult[0];
                    top = currentResult[1];
                    bottom = currentResult[2];
                    left = leftCol;
                    right = rightCol;
                }
            }
        }*/
        System.out.println("MaxSum: " + maxSum + ", range: [(" + left + ", " + top + ")(" + right + ", " + bottom + ")]");
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
