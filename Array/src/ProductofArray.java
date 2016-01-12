
public class ProductofArray {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] test = {1,2,3,4};
        printArray(productExceptSelf(test));
    }
    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] first = new int[n];
        first[0] = 1;
        //create an array that is the product of all the elements except last one
        //{[inital value = 1], [n[1]], [n[1]*n[2]], [n[1]*n[2]*n[3]]}
        for (int i = 1; i < n; i++) {
            first[i] = first[i-1] * nums[i-1];
        }
        //create an array that is the product of all the elements except first one
        //{[n[2]*n[3]*n[4]], [n[3]*n[4]], [n[4]] [last value = 1]}
        int[] reverse = new int[n];
        int[] res = new int[n];
        reverse[n-1] = 1;
        for (int i = n-2; i >= 0; i--) {
            reverse[i] = reverse[i+1] * nums[i+1];
        }
        for (int i = 0; i < n; i++) {
            res[i] = first[i] * reverse[i];
        }
        return res;
        /*
        int n = nums.length;
        int[] res = new int[n];
        res[0] = 1;
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }
        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] *= right;
            right *= nums[i];
        }
        return res;
        */
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
