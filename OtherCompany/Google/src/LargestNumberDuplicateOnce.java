/**
 * Created by Administrator on 2016/10/22.
 */
public class LargestNumberDuplicateOnce {
    public static void main(String[] args) {
        printArray(duplicateNumber(new int[]{1, 1, 2, 3, 4, 5}));
        printArray(duplicateNumber(new int[]{1, 3, 2, 3, 4, 5}));
    }

    public static int[] duplicateNumber(int[] input) {
        // check for boundary cases
        if (input == null || input.length == 0) return new int[0];
        int[] result = new int[input.length + 1];
        if (input.length == 1) return new int[]{input[0], input[0]};
        int i = 0, j = 0;
        while (i < input.length - 1) {
            if (input[i] <= input[i + 1]) {
                result[j++] = input[i++];
            } else {
                result[j++] = input[i];
                while (j < result.length) result[j++] = input[i++];
                return result;

            }

        }
        result[j] = input[input.length - 1];
        result[j + 1] = input[input.length - 1];
        return result;
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
