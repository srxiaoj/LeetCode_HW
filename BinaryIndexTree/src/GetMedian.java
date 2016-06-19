import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by thanksgiving on 6/19/16.
 */
public class GetMedian {
    public static void main(String[] args) {
        System.out.println(getMedian(new int[]{6, 3, -1, -5}));
        System.out.println(getMedian(new int[]{6, 3, -1, -5, 5}));
    }

    private static int getMedian(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return 0;

        int n = nums.length;
        int[] nums2 = new int[n];
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            min = Math.min(min, nums[i]);
        }

        for (int i = 0; i < n; i++) {
            nums2[i] = nums[i] - min + 1;
            max = Math.max(max, nums2[i]);
        }
        int[] tree = new int[max + 1];
        int[] reverseTree = new int[max + 1];
        int[] reverseNum = reverse(nums2);
        List<Integer> smallerRightCountList = new ArrayList<>();
        List<Integer> smallerLeftCountList = new ArrayList<>();
        for (int i = n - 1; i >= 0; i--) {
            smallerRightCountList.add(0, getRightSmallerCount(tree, nums2[i] - 1));
            update(tree, nums2[i]);
            smallerLeftCountList.add(0, getRightSmallerCount(reverseTree, reverseNum[i] - 1));
            update(reverseTree, reverseNum[i]);
        }
        Collections.reverse(smallerLeftCountList);
        System.out.println(smallerLeftCountList);
        System.out.println(smallerRightCountList);

        List<Integer> smallerSumList = new ArrayList<>();

        for (int i = 0; i < smallerLeftCountList.size(); i++) {
            int sum = smallerLeftCountList.get(i) + smallerRightCountList.get(i);
            smallerSumList.add(sum);
            if (n % 2 != 0 && smallerSumList.get(i) == n / 2) {
                return nums[i];
            } else if (n % 2 == 0) {
                if (sum == n / 2 || sum == (n - 1) / 2) {
                    res.add(nums[i]);
                }
            }
        }
        if (res.size() < 2) return 0;
        System.out.println("two median number: " + res);
        int median = (res.get(0) + res.get(1)) / 2;
        return median;
    }

    private static int getRightSmallerCount(int[] tree, int i) {
        int num = 0;
        while (i > 0) {
            num += tree[i];
            i = i - (i & (-i));
        }
        return num;
    }

    private static void update(int[] tree, int i) {
        while (i < tree.length) {
            tree[i]++;
            i = i + (i & (-i));
        }
    }

    private static int[] reverse(int[] num) {
        int[] reverse = new int[num.length];
        for (int i = 0; i < num.length; i++) {
            reverse[i] = num[num.length - i - 1];
        }
        return reverse;
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
