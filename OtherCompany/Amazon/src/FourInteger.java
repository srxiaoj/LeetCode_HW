import java.util.Arrays;

/**
 * Given four integers, make F(S) = abs(S[0]-S[1])+abs(S[1]-S[2])+abs(S[2]-S[3]) to be largest
 */
public class FourInteger {
    public static void main(String[] args) {
        printArray(largest(3, 5, 1, 2));
    }

    public static int[] largest(int A, int B, int C, int D) {
        int[] res = new int[] {A, B, C, D};
        Arrays.sort(res);
        swap(res, 0, 1);
        swap(res, 2, 3);
        swap(res, 0, 3);
        return res;
    }

    private static void swap(int[] nums, int i, int j) {
        nums[i] ^= nums[j];
        nums[j] ^= nums[i];
        nums[i] ^= nums[j];
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
