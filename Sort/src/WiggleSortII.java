import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WiggleSortII {
    public static void main(String[] args) {
        int[] n1 = {1, 5, 1, 1, 6, 4};
        wiggleSort(n1);
        printArray(n1);

        int[] n2 = {4, 5, 5, 6};
//        wiggleSort(n2);
//        printArray(n2);

        int[] n3 = {1, 1, 2, 1, 2, 2, 1};
//        wiggleSort(n3);
//        printArray(n3);

        int[] n4 = {5, 6, 4, 13, 2, 5};
        wiggleSort(n4);
        printArray(n4);
    }

    /**
     * 方法1
     * https://discuss.leetcode.com/topic/41464/step-by-step-explanation-of-index-mapping-in-java/2
     */
    public static void wiggleSort(int[] nums) {
        int median = findKthLargest(nums, (nums.length + 1) / 2);
        printArray(nums);
        int n = nums.length;
        int left = 0, i = 0, right = n - 1;
        while (i <= right) {
            int mapIndex = newIndex(i, n);
            System.out.println("mapIndex: " + mapIndex + ", nums[mapIndex]: " + nums[mapIndex]);
            System.out.println("BEFORE left: " + left + ", i: " + i + ", right: " + right);
            if (nums[mapIndex] > median) {
                swap(nums, newIndex(left++, n), newIndex(i++, n));
            } else if (nums[mapIndex] < median) {
                swap(nums, newIndex(right--, n), newIndex(i, n));
            } else {
                i++;
            }
            printArray(nums);
            System.out.println("AFTER left: " + left + ", i: " + i + ", right: " + right);
        }
    }

    private static int newIndex(int index, int n) {
        return (1 + 2 * index) % (n | 1);
    }

    public static int findKthLargest(int[] nums, int k) {
        //method 2, partial quicksort, O(nlogk)
        int l = 0, r = nums.length - 1;
        while (true) {
            int p = partition(nums, l, r);
            if (p == k - 1) return nums[k - 1];
            if (p > k - 1) r = p - 1;
            else l = p + 1;
        }
    }

    private static int partition(int[] array, int l, int r) {
        int p = l;
        int pValue = array[l];
        for (int i = l + 1; i <= r; i++) {
            if (array[i] > pValue) {
                p++;
                swap(array, i, p);
            }
        }
        swap(array, p, l);
        return p;
    }


    /**
     * 方法2
     * 先排序，然后每次取(len - 1) / 2位置以及最大位置元素
     * O(nlog(n))
     */
    public static void wiggleSort2(int[] nums) {
        if (nums == null || nums.length <= 1) return;
        List<Integer> list = new ArrayList<>();
        for (int i : nums) {
            list.add(i);
        }
        Collections.sort(list);
        int i = 0;
        while (list.size() > 1) {
            int len = list.size();
            nums[i++] = list.get((len - 1) / 2);
            nums[i++] = list.get(len - 1);
            list.remove((len - 1) / 2);
            list.remove(list.size() - 1);
        }
        if (list.size() == 1) {
            nums[i] = list.get(0);
        }
    }

    private static void swap(int[] nums, int i, int j) {
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
