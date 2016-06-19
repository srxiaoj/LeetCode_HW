import java.util.LinkedList;
import java.util.List;

/**
 * Created by thanksgiving on 6/18/16.
 */
public class CountofSmallerNumbersAfterSelf {
    public static void main(String[] args) {
        CountofSmallerNumbersAfterSelf obj = new CountofSmallerNumbersAfterSelf();
        System.out.println(obj.countSmaller(new int[]{10, 6, 1, 3, 9, 20, 4, 15, 17}));
        System.out.println(obj.countSmaller(new int[]{-1}));
    }


    /**
     * 将tree[] 取为一个以nums中最大的数为size的array， 然后从右往左去数每个比当前数小的count
     * 数完之后update tree[]
     */
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new LinkedList<Integer>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        // find min value and minus min by each elements, plus 1 to avoid 0 element
        // 找到数组中最小值，如果最小值为负数则把所有元素都 - min + 1
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
//            min = (nums[i] < min) ? nums[i] : min;
            min = Math.min(nums[i], min);
        }
        printArray(nums);
        int[] nums2 = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            nums2[i] = nums[i] - min + 1;
            max = Math.max(nums2[i], max);
        }
        printArray(nums2);
        int[] tree = new int[max + 1];
        for (int i = nums2.length - 1; i >= 0; i--) {
            res.add(0, getSmallerCount(nums2[i] - 1, tree));
            update(nums2[i], tree);
        }

        printArray(tree);
        printArray(nums2);
        return res;
    }

    private int getSmallerCount(int i, int[] tree) {
        int num = 0;
        while (i > 0) {
            num += tree[i];
            i -= i & (-i);
        }
        return num;
    }

    private void update(int i, int[] tree) {
        while (i < tree.length) {
            tree[i]++;
            i += i & (-i);
        }
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
