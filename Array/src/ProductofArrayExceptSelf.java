
public class ProductofArrayExceptSelf {

    public static void main(String[] args) {
        int[] test = {1, 2, 3, 4};
        Utils.printArray(productExceptSelf(test));
    }

    public static int[] productExceptSelf(int[] nums) {
        // O(2*n) 空间
       /* int n = nums.length;
        int[] first = new int[n];
        first[0] = 1;
        //create an array that is the product of all the elements except last one
        //{[inital value = 1], [n[1]], [n[1]*n[2]], [n[1]*n[2]*n[3]]}
        for (int i = 1; i < n; i++) {
            first[i] = first[i - 1] * nums[i - 1];
        }
        printArray(first);
        // reverse it
        //{[n[2]*n[3]*n[4]], [n[3]*n[4]], [n[4]] [last value = 1]}
        int[] reverse = new int[n];
        reverse[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            reverse[i] = reverse[i + 1] * nums[i + 1];
        }
        printArray(reverse);
        //create an array that is the product of all the elements except first one
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = first[i] * reverse[i];
        }
        return res;*/

        // O(n)空间

        if (nums == null || nums.length == 0) return new int[0];
        int n = nums.length;
        int forward = 1;
        int[] back = new int[n];
        back[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            back[i] = back[i + 1] * nums[i + 1];
        }

        for (int i = 0; i < n; i++) {
            back[i] = back[i] * forward;
            forward = forward * nums[i];
        }
        return back;

    }
}
