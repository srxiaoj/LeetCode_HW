/**
 * Created by thanksgiving on 6/4/16.
 */
public class HeapSort {
    /* Class HeapSort */
    private static int N;

    /* Sort Function */
    public static void sort(int[] num) {
        N = num.length - 1;

        // 将heap初始化为所有的parent都比children节点的值要大
        buildHeap(num);
        // 每次heapfy都将第一个数（当前的最大数）与最后一个位置交换，并且不断减小最后一个位置
        // 从而得到升序排序
        for (int i = N; i > 0; i--) {
            swap(num, 0, i);
            N = N - 1;
            heapify(num, 0);
        }
    }

    /**
     * 将heap初始化为所有的parent都比children节点的值要大
     */
    public static void buildHeap(int[] num) {
        for (int i = N / 2; i >= 0; i--) {
            heapify(num, i);
        }
        System.out.println("Elements after buildHeap ");
        Utils.printArray(num);
    }

    /**
     * 从底至上，如果左右节点的值有比parent值大的，那么就swap，并且重新heapify那个max节点
     */
    public static void heapify(int[] num, int i) {
        int left = 2 * i;
        int right = 2 * i + 1;
        int max = i;
        if (left <= N && num[left] > num[i])
            max = left;
        if (right <= N && num[right] > num[max])
            max = right;

        if (max != i) {
            swap(num, i, max);
            heapify(num, max);
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    /* Main method */
    public static void main(String[] args) {
        int[] arr = {4, 6, 2, 1, 9, 8, 101, 20, 3};
        /* Call method sort */
        sort(arr);
        System.out.println("Elements after sorting ");
        Utils.printArray(arr);
    }
}
