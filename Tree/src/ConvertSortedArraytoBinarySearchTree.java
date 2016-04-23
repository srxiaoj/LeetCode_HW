/**
 * Created by thanksgiving on 4/22/16.
 */
public class ConvertSortedArraytoBinarySearchTree {
    public static void main(String[] args) {
        ConvertSortedArraytoBinarySearchTree obj = new ConvertSortedArraytoBinarySearchTree();
        int[] test = {1, 3, 4, 5, 6, 9, 11, 12};
        TreeNode res = obj.sortedArrayToBST(test);
        TreeNode.printNode(res);
    }

    /**
     * use mid as root, and recursive call left half and right half as left and right child
     * if (l > r) the node should be null
     * @param nums
     * @return
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        int l = 0;
        int r = nums.length - 1;
        return helper(nums, l, r);
    }

    private TreeNode helper(int[] nums, int l, int r) {
        if (l > r) return null;
        int mid = l + (r - l) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        if (l < r) {
            root.left = helper(nums, l, mid - 1);
            root.right = helper(nums, mid + 1, r);
        }
        return root;
    }
}
