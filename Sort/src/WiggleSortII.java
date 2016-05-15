
public class WiggleSortII {
    public static void main(String[] args) {
        WiggleSortII obj = new WiggleSortII();
//        int[] n1 = {1, 5, 1, 1, 6, 4};
//        obj.wiggleSort(n1);
//        printArray(n1);

        int[] n2 = {4, 5, 5, 6};
        obj.wiggleSort(n2);
        printArray(n2);

        int[] n3 = {1, 1, 2, 1, 2, 2, 1};
        obj.wiggleSort(n3);
        printArray(n3);

        int[] n4 = {1, 1, 2, 2, 2, 1};
        obj.wiggleSort(n4);
        printArray(n4);
    }
    public void wiggleSort(int[] nums) {

    }


/*

    public void wiggleSort(int[] nums) {
        int i = 0, j = nums.length - 1, k = nums.length - 1;
        while (i < nums.length - 1) {
            if (i % 2 == 0) {
                if (i < nums.length - 1 && nums[i] < nums[i + 1]) {
                    i++;
                } else if (i < nums.length - 1 && nums[i] >= nums[i + 1]) {
                    j = Math.max(j, k);
                    while (j > 0 && nums[j] <= nums[i]) {
                        j--;
                    }
                    swap(nums, i + 1, j);
                }
            } else {
                if (i < nums.length - 1 && nums[i] > nums[i + 1]) {
                    i++;
                } else if (i < nums.length - 1 && nums[i] <= nums[i + 1]) {
                    k = Math.max(j, k);
                    while (k > 0 && nums[k] >= nums[i]) {
                        k--;
                    }
                    swap(nums, i + 1, k);
                }
            }
        }
    }
*/

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    //print array
    public static void printArray(int[] A) {
        for (int i = 0; i < A.length; i++) {
            if (i != A.length - 1)
                System.out.print(A[i] + ", ");
            else
                System.out.print(A[i]);
        }
        System.out.println("");
    }
}
