import java.util.Arrays;


public class HouseRobberII {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] test =   {3, 5, 1, 6, 9, 10, 8, 3, 7, 1};
        System.out.println(rob2(test));
        int[] test2= {3, 5, 1, 6, 9, 1};
        System.out.println(rob2(test2));
    }
    private static int rob2(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];
        int[] numsNoFirstElement = new int[n];
        int[] numsNoLastElement = new int[n];
        numsNoFirstElement = Arrays.copyOfRange(nums, 1, n);
        numsNoLastElement = Arrays.copyOfRange(nums, 0, n-1);
//        printArray(numsNoFirstElement);
//        printArray(numsNoLastElement);
        return Math.max(robHelper(numsNoLastElement), robHelper(numsNoFirstElement));
    }
    public static int robHelper(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int[] robbedValue = new int[n + 1];
        boolean[] isRobbed = new boolean[n + 1];
//        isRobbed[0] = true;
        Arrays.fill(robbedValue, Integer.MIN_VALUE);
        Arrays.fill(isRobbed, false);
        robbedValue[0] = 0;
        robbedValue[1] = nums[0];
        for (int i = 2; i <= n; i++) {
            robbedValue[i] = Math.max(robbedValue[i-1], robbedValue[i-2] + nums[i-1]);
        }
        // get the house that has been stolen
        int newMax = robbedValue[n];
        for (int i  = n; i >= 2; i--) {
            if (robbedValue[i] != robbedValue[i-1] && newMax == robbedValue[i]) {
                newMax = newMax - nums[i-1];
//                System.out.println(newMax);
                isRobbed[i] = true;
            } else {
                isRobbed[i] = false;
            }
        }
//        printArray(robbedValue);
//        printArray(isRobbed);
        return robbedValue[n];
    }
    //print array
    public static void printArray(boolean[] A)
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
