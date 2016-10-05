/**
 * 给一个数组，让写一个函数判断如果最多只swap数组里的两个元素一次能否使数组变成有序的（升序）。
 */
public class ascendingArrayOneSwap {
    public static void main(String[] args) {
        System.out.println(canSwap(new int[]{3, 2, 1}));
        System.out.println(canSwap(new int[]{1, 3, 2}));
        System.out.println(canSwap(new int[]{3, 1, 2}));
        System.out.println(canSwap(new int[]{6, 5, 4, 3, 2, 1}));
        System.out.println(canSwap(new int[]{3, 1, 2, 4, 5, 6}));
        System.out.println(canSwap(new int[]{1, 7, 3, 4, 5, 6, 2}));
        System.out.println(canSwap(new int[]{1, 5, 3, 3, 7}));
        System.out.println(canSwap(new int[]{1, 5}));
        System.out.println(canSwap(new int[]{1, 1}));
    }

    public static boolean canSwap(int[] A) {
        if (A == null || A.length == 0) return false;
        if (A.length <= 2) return A[0] != A[A.length - 1];
        int n = A.length;
        Integer wrongLarge = null, wrongSmall = null;
        for (int i = 0; i < n - 1; i++) {
            if (A[i] >= A[i + 1] && wrongLarge == null) {
                wrongLarge = i;
            }
        }

        for (int i = n - 1; i > 0; i--) {
            if (A[i] <= A[i - 1] && wrongSmall == null) {
                wrongSmall = i;
            }
        }
        if (wrongLarge == null && wrongSmall == null) return true;
        if (wrongLarge == null || wrongSmall == null) return false;
//        System.out.println("wrongLarge: " + wrongLarge + ", wrongSmall: " + wrongSmall);
        swap(A, wrongLarge, wrongSmall);
        for (int i = 1; i < n; i++) {
            if (A[i] < A[i - 1]) return false;
        }

        return true;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
