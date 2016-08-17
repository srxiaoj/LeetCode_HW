import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WiggleSortII {
    public static void main(String[] args) {
        int[] n1 = {1, 5, 1, 1, 6, 4};
        wiggleSort(n1);
        printArray(n1);

        int[] n2 = {4, 5, 5, 6};
        wiggleSort(n2);
        printArray(n2);

        int[] n3 = {1, 1, 2, 1, 2, 2, 1};
        wiggleSort(n3);
        printArray(n3);

        int[] n4 = {5, 6, 4, 13, 2, 5};
        wiggleSort(n4);
        printArray(n4);

        int[] n5 = {5, 3, 1, 2, 6, 7, 8, 5, 5};
        wiggleSort(n5);
        printArray(n5);

        int[] n6 = {1, 2, 2, 5, 2, 1, 5, 2, 1, 3, 4, 4, 1, 5, 2};
        wiggleSort(n6);
        printArray(n6);
    }

    /**
     * 方法1: https://discuss.leetcode.com/topic/38189/clear-java-o-n-avg-time-o-n-space-solution-using-3-way-partition
     */
    public static void wiggleSort(int[] nums) {
        int median = findKthSmallest(nums, 0, nums.length - 1, nums.length % 2 == 0 ? nums.length / 2 : nums.length / 2 + 1);
        System.out.println("after sort");
        printArray(nums);

        List<Integer> left = new ArrayList<Integer>();
        List<Integer> right = new ArrayList<Integer>();
        for (int i = 0; i <= median; i++) left.add(nums[i]);
        for (int i = median + 1; i < nums.length; i++) right.add(nums[i]);

        int l = left.size() - 1, r = right.size() - 1;
        int i = 0;
        while (r >= 0) {
            nums[i] = left.get(l);
            nums[i + 1] = right.get(r);
            l--;
            r--;
            i += 2;
        }
        if (nums.length % 2 != 0) {
            nums[nums.length - 1] = left.get(0);
        }
    }

    private static int findKthSmallest(int[] nums, int start, int end, int k) {
        int[] res = partitionArray(nums, start, end);
        int l = res[0];
        int r = res[1];
        if (k - 1 < l) {
            return findKthSmallest(nums, start, l - 1, k);
        } else if (k - 1 > r) {
            return findKthSmallest(nums, r + 1, end, k);
        } else {
            return k - 1;
        }
    }

    /**
     * partition the data so that all the value equals the median are order together within lower bound and higher bound
     */
    private static int[] partitionArray(int[] nums, int lb, int hb) {
        int pVal = nums[lb];
        int i = lb;
        while (i <= hb) {
            if (nums[i] == pVal) {
                i++;
            } else if (nums[i] < pVal) {
                swap(nums, i++, lb++);
            } else {
                swap(nums, i, hb--);
            }
        }
        int[] res = new int[2];
        res[0] = lb;
        res[1] = hb;
        return res;
    }


    /**
     * 方法2
     * 先排序，然后每次取len / 2位置以及最大位置元素
     * O(nlog(n))
     */
    public static void wiggleSort2(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int n : nums) {
            list.add(n);
        }

        Collections.sort(list, Collections.reverseOrder());
        int n = nums.length;
        int i = 0;
        // incase the number of list is odd
        while (i < n - 1) {
            nums[i++] = list.get(list.size() / 2);
            nums[i++] = list.get(0);
            list.remove(list.size() / 2);
            list.remove(0);
        }
        if (list.size() == 1) {
            nums[i] = list.get(0);
        }
      /*  if (nums == null || nums.length <= 1) return;
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
        }*/
    }


    /**
     * 方法3 virtual index
     * https://discuss.leetcode.com/topic/41464/step-by-step-explanation-of-index-mapping-in-java/2
     */
    public static void wiggleSort3(int[] nums) {
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
            int p = partitionDesc(nums, l, r);
            if (p == k - 1) return nums[k - 1];
            if (p > k - 1) r = p - 1;
            else l = p + 1;
        }
    }

    private static int partitionDesc(int[] array, int l, int r) {
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
