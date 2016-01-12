import java.util.Stack;

public class UglyNumberII {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(nthUglyNumber(14));
    }

    public static int nthUglyNumber(int n) {
        /**
         * The idea of this solution is from this
         * page:http://www.geeksforgeeks.org/ugly-numbers/
         * 
         * The ugly-number sequence is 1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 15, ¡­
         * because every number can only be divided by 2, 3, 5, one way to look
         * at the sequence is to split the sequence to three groups as below:
         * 
         * (1) 1¡Á2, 2¡Á2, 3¡Á2, 4¡Á2, 5¡Á2, ¡­ (2) 1¡Á3, 2¡Á3, 3¡Á3, 4¡Á3, 5¡Á3, ¡­ (3)
         * 1¡Á5, 2¡Á5, 3¡Á5, 4¡Á5, 5¡Á5, ¡­ We can find that every subsequence is the
         * ugly-sequence itself (1, 2, 3, 4, 5, ¡­) multiply 2, 3, 5.
         * 
         * Then we use similar merge method as merge sort, to get every ugly
         * number from the three subsequence.
         * 
         * Every step we choose the smallest one, and move one step
         * after,including nums with same value.
         */
        
        //method 1
        int[] ugly = new int[n];
        ugly[0] = 1;
        int index2 = 0, index3 = 0, index5 = 0;
        int factor2 = 2, factor3 = 3, factor5 = 5;
        for(int i=1;i<n;i++){
            int min = Math.min(Math.min(factor2,factor3),factor5);
            ugly[i] = min;
            if(factor2 == min)
                factor2 = 2 * ugly[++index2];
            if(factor3 == min)
                factor3 = 3 * ugly[++index3];
            if(factor5 == min)
                factor5 = 5 * ugly[++index5];
        }
        printArray(ugly);
        return ugly[n-1];
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
