import java.util.Arrays;

public class CutRod {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] price = {1, 5, 8, 9, 10, 17, 17, 20, 24, 30};
        int len = 3;
        int[] index = new int[len + 1];
//        System.out.println(MemoizedCutRod(price, 6));
        System.out.println(BottomUpCutRod(price, len, index));
        printSolution(index, len);
        System.out.println("");
        System.out.println(BottomUpCutRodExtraCutCost(price, len, 1));
    }
    /**
     * bottom up DP, each cut is free
     * @param price an array of price at each length
     * @param len the total length of the rod
     * @return
     */
    public static int BottomUpCutRod(int[] price, int len, int[] index) {
        int[] subMax = new int[len + 1];
        
        subMax[0] = 0;
        for (int i = 1; i <= len; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = 1; j <= i; j++) {
                // to print out the first index that rod that has been selected
                if (max < price[j - 1] + subMax[i - j]) {
                    index[i] = j;
                }
                // the key is that result[len] should use price[j-1] instead of price[j]
                // index j - 1 corresponding to the jth price
                max = Math.max(max, price[j - 1] + subMax[i - j]);
            }
            subMax[i] = max;
        }
        return subMax[len];
    }
    private static void printSolution(int[] index, int len) {
        System.out.println("cut the rod at position: ");
        while (len > 0) {
            System.out.print(index[len] + " ");
            len = len - index[len];
        }
    }
    /**
     * bottom up DP, has a extra cost for each cut
     * @param price
     * @param len
     * @param cost
     * @return
     */
    public static int BottomUpCutRodExtraCutCost(int[] price, int len, int cost) {
        int[] subMax = new int[len + 1];
        subMax[0] = 0;
        
        for (int i = 1; i <= len; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = 1; j <= i; j++) {
                if (j < i) {
                    max = Math.max(max, price[j - 1] + subMax[i - j] - cost);
                } else {
                    max = Math.max(max, price[j - 1] + subMax[i - j]);
                }
            }
            subMax[i] = max;
        }
        return subMax[len];
    }
    /**
     * top down DP.
     * @param price an array of price at each length
     * @param len the total length of the rod
     * @return
     */
    public static int MemoizedCutRod(int[] price, int len) {
        if (len == 0) return 0;
        int[] subMax = new int[len + 1];
        Arrays.fill(subMax, Integer.MIN_VALUE);
        subMax[0] = 0; //if length is 0, the total should be 0
        return MemoizedCutRodHelper(price, len, subMax);
    }
    private static int MemoizedCutRodHelper(int[] price, int len, int[] subMax) {
        int max = Integer.MIN_VALUE;
        //if the result has been computed, then use it, otherwise compute it
        if (subMax[len] >= 0) return subMax[len]; 
        for (int i = 1; i <= len; i++) {
            // the key is that result[len] should use price[i-1] instead of price[i]
            max = Math.max(max, price[i - 1]
                    + MemoizedCutRodHelper(price, len - i, subMax));
        }
        subMax[len] = max;
        return max;
    }
    //print array
    public static void printArray(int[] A)
    {
        for(int i = 0; i < A.length; i++)
        {
            if(i != A.length-1)
                System.out.print(A[i] + ", ");
            else
                System.out.print(A[i]);
        }
        System.out.println("");
    }
}
