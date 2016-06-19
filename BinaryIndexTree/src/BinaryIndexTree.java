/**
 * Created by thanksgiving on 6/18/16.
 */
public class BinaryIndexTree {
    public static void main(String[] args) {
//        int[] freq = new int[] {2, 1, 1, 3, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] freq = new int[]{10, 6, 1, 3, 9, 20, 4, 15, 17};
        int n = freq.length;
        int[] BITree = constructBITree(freq, n);
        for (int i = 0; i < n; i++) {
            int temp = i + 1;
            System.out.print(getSum(BITree, i) + ", ");
        }
        System.out.println();
        printArray(BITree);
    }

    private static int[] constructBITree(int[] arr, int n) {
        int[] BITree = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            BITree[i] = 0;
        }

        for (int i = 0; i < n; i++) {
            updateBIT(BITree, n, i, arr[i]);
        }

        return BITree;
    }

    private static void updateBIT(int[] BITree, int n, int index, int val) {
        index++;
        while (index <= n) {
            BITree[index] += val;
            index += index & (-index);
        }
    }

    private static int getSum(int[] BITree, int index) {
        int sum = 0;
        index++;
        while (index > 0) {
            sum += BITree[index];
            index -= index & (-index);
        }
        return sum;
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
