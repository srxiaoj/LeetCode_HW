/**
 * Created by thanksgiving on 1/29/16.
 */
public class ConvertSortedArraytoBinarySearchTree {
    public static void main(String[] args) {
        ConvertSortedArraytoBinarySearchTree obj = new ConvertSortedArraytoBinarySearchTree();
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        TreeNode res = obj.sortedArrayToBST(nums);
        TreeNode.printNode(res);
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        int n = nums.length;

        TreeNode root = helper(nums, 0, n - 1);
        return root;
    }

    private TreeNode helper(int[] nums, int l, int r) {
        if (r < l) return null;
        int mid = (l + r) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, l, mid - 1);
        root.right = helper(nums, mid + 1, r);
        return root;
    }
}
