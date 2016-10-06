/**
 * Created by Administrator on 2016/10/5.
 */
public class SortArray {
    public static void main(String[] args) {
        printArray(sortArray(new int[] {5, 3, 8, 1, 7}));
        printArray(sortArray2(new int[] {5, 3, 8, 1, 7}));
    }

    public static int[] sortArray(int[] arr) {
        int len = arr.length;
        int i, j, temp;
        for (i = 0; i <= len - 1; i++) {
            for (j = i; j < len; j++) {
                if (arr[i] < arr[j]) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }

    public static int[] sortArray2(int arr[]) {
        int i, max, location, j, temp, len = arr.length;
        for (i = 0; i < len; i++) {
            max = arr[i];
            location = i;
            for (j = i; j < len; j++) {
                if (max < arr[j]) {
                    max = arr[j];
                    location = j;
                }
            }
            temp = arr[i];
            arr[i] = arr[location];
            arr[location] = temp;
        }
        return arr;
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
