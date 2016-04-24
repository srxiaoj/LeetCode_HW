import java.util.Stack;

public class BinaryTreeUpsideDown {

    public static void main(String[] args) {
//        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(2);
//        root.right = new TreeNode(3);
//        root.left.left = new TreeNode(4);
//        root.left.right = new TreeNode(5);
//        System.out.println("Before inverse");
//        TreeNode.printNode(root);
//        System.out.println("After inverse");
//        TreeNode res = upsideDownBinaryTree(root);
//        TreeNode.printNode(res);
//
//        TreeNode root2 = new TreeNode(1);
//        root2.left = new TreeNode(2);
//        System.out.println("Before inverse");
//        TreeNode.printNode(root2);
//        System.out.println("After inverse");
//        TreeNode res2 = upsideDownBinaryTree(root2);
//        TreeNode.printNode(res2);

        TreeNode root3 = new TreeNode(1);
        root3.left = new TreeNode(2);
        root3.left.left = new TreeNode(3);
        System.out.println("Before inverse");
        TreeNode.printNode(root3);
        System.out.println("After inverse");
        TreeNode res3 = upsideDownBinaryTree(root3);
        TreeNode.printNode(res3);
    }

    /**
     * 存入stack时只存left child,然后以left child为迭代节点，进行peek()
     * 如果peek的right child为null, 则当前节点左为null, 节点右为peek值
     * 注意观察， 左节点分别为 1 - 2 - 4
     *     1
     *    / \
     *   2   3
     *  / \
     * 4   5
     *
     * 变换后右边节点分别为 4 - 2 - 1
     * 所以stack只需要存最左边的值
     * @param root
     * @return
     */
    public static TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null) return null;
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        TreeNode res = null;
        TreeNode temp = null;
        while (!stack.isEmpty()) {
            TreeNode curNode = stack.lastElement();
            if (curNode.left != null) {
                stack.add(curNode.left);
                curNode.left = null;
            } else {
                if (res == null) {
                    res = new TreeNode(curNode.val);
                    temp = res;
                } else { // res != null
                    // add temp.left
                    if (curNode.right != null) {
                        temp.left = new TreeNode(curNode.right.val);
                    } else {
                        temp.left = null;
                    }
                    // add temp.right
                    temp.right = new TreeNode(curNode.val);
                    temp = temp.right;
                }
                stack.pop();
            }
        }
        return res;
    }
}
