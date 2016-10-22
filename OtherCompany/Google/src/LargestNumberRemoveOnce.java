/**
 * Created by Administrator on 2016/10/22.
 */
public class LargestNumberRemoveOnce {
    public static void main(String[] args) {
        printArray(removeOneChar(new int[]{1, 2, 2, 3, 3, 4})); // 1,2,3,3,4
        printArray(removeOneChar(new int[]{1, 3, 3, 2, 2}));    // 1,3,3,2
        printArray(removeOneChar(new int[]{1, 3, 3, 2, 2, 5})); // 1,3,3,2,5
        printArray(removeOneChar(new int[]{1, 3, 3, 2, 5, 5})); // 1,3,3,2,5
        printArray(removeOneChar(new int[]{1, 5, 5, 2, 4, 4})); // 1,5,5,2,4
        printArray(removeOneChar(new int[]{1, 5, 5, 2, 6, 6})); // 1,5,5,2,6
        printArray(removeOneChar(new int[]{1, 2, 3, 3, 4, 7, 7})); // 1,2,3,4,7,7
        printArray(removeOneChar(new int[]{1, 2, 3}));             // 1,2,3
        printArray(removeOneChar(new int[]{1}));                   // 1
    }

    public static int[] removeOneChar(int[] input) {
        // check for boundary cases
        if (input == null || input.length == 0) return new int[0];
        int n = input.length;
        if (n == 1) return input;
        int[] result = new int[n - 1];
        int i = 0, j = 0;
        while (i < n - 1) {
            if (i == 0 || input[i] >= input[i + 1]) {
                result[j++] = input[i++];
            } else {
                if (input[i] == input[i - 1]) {
                    i++;
                    while (j < result.length) result[j++] = input[i++];
                    return result;
                } else {
                    result[j++] = input[i++];
                }
            }
        }
        if (input[i] == input[i - 1]) {
            return result;
        }
        return input;
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
