import java.util.LinkedList;
import java.util.List;

public class MaximumProductSubarray {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] test = {2, 3, -2, -4, 1};
        System.out.println(maxProduct(test));
        
        int[] test2 = {-4, -3};
        System.out.println(maxProduct(test2));
    }
    public static int maxProduct(int[] A) {
        if (A.length == 0) {
            return 0;
        }

        int maxherepre = A[0];
        int minherepre = A[0];
        int maxsofar = A[0];
        int maxhere, minhere;

        for (int i = 1; i < A.length; i++) {
            //if A[i] has the same sign of minherepre, then minhere will be the new max
            maxhere = Math.max(Math.max(maxherepre * A[i], minherepre * A[i]), A[i]); //use previous max and previous min to get new max
            minhere = Math.min(Math.min(maxherepre * A[i], minherepre * A[i]), A[i]);
            maxsofar = Math.max(maxhere, maxsofar);
            maxherepre = maxhere; // store the previous max value
            minherepre = minhere; // store the previous min value
        }
        return maxsofar;
    }
}
