import java.util.Arrays;
import java.util.Random;

/**
 * https://www.youtube.com/watch?v=54rMYC2pEtw
 * 1 2 3 4 5 6 7 8 9
 * 假设当i为3时，前面shuffle sort的结果有两种
 * {1 2}, {2 1}
 * 然后3可以在2的基础上出现3种情况
 * {3 2 1}, {1 3 2} {1 2 3}以及{3 1 2}, {2 3 1}, {2 1 3}
 * 所以3的所有可能出现情况为3!,同理n个数shuffle sort的结果有n!种，且每种概率相同
 */
public class ShuffleanArray {
    public static void main(String[] args) {
        ShuffleanArray s = new ShuffleanArray(new int[] {1, 2, 3});
        int[] res = s.shuffle();
        printArray(res);
        res = s.shuffle();
        printArray(res);
        res = s.shuffle();
        printArray(res);
    }

    int[] nums;
    Random r;
    public ShuffleanArray(int[] nums) {
        this.nums = nums;
        this.r = new Random();
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return Arrays.copyOfRange(nums, 0, nums.length);
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int[] copy = Arrays.copyOfRange(nums, 0, nums.length);
        for (int i = 0; i < copy.length; i++) {
            int randomIndex = r.nextInt(i + 1);
            swap(copy, randomIndex, i);
        }
        return copy;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
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
