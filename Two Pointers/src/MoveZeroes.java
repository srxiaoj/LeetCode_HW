
public class MoveZeroes {

    public static void main(String[] args) {
        int[] test = {2, 1, 0, 3, 12};
        moveZeroes(test);
        printArray(test);
    }
    public static void moveZeroes(int[] nums) {
        int i = 0, id1 = 0;
        while (i < nums.length) {
            if (nums[i] != 0) {
                nums[id1] = nums[i];
                id1++;
            }
            i++;
        }

        i = id1;
        while (i < nums.length) {
            nums[i] = 0;
            i++;
        }


        /**
         * insertion sort
         */
        /*for (int i = 1; i < nums.length; i++) {
            for (int j = i; j > 0; j--) {
                //core step, treat 0 as the biggest number
                //only swap 0, but not the others
                if (nums[j - 1] == 0 && nums[j] != 0) {
                    swap(nums, j, j - 1);
                }
            }
        }*/
    }
    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
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
