import java.util.Random;

/**
 * Created by thanksgiving on 9/16/16.
 */
public class RandomChooseKFromArray {
    public static void main(String[] args) {
        printArray(selectKItems(new int[] {1, 2, 3, 4, 5, 6}, 3));
    }

    public static int[] selectKItems(int[] nums, int k) {
        int[] res = new int[k];
        Random r = new Random();
        for (int i = 0; i < k; i++) {
            res[i] = nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            int j = r.nextInt(i + 1);
            if (j < k) {
                res[j] = nums[i];
            }
        }
        return res;
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
