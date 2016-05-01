
public class Insert {

    public static void main(String[] args) {
        TreeNode root = TreeNode.deserializeLevelorder("15,8,20,5,null,17,null,null,null,16,null");
        insert(10, root);
        System.out.println(root.left.right.val);
    }
    public static void insert(int x, TreeNode root) {
        TreeNode newNode = new TreeNode(x);
        if (root == null) root = newNode;
        TreeNode current = root;
        TreeNode parent;
        while (true) {
            parent = current;
            if (x < current.val) { //check left child
                current = current.left;
                if (current == null) {
                    parent.left = newNode;
                    return;
                }
            } else { // check right child
                current = current.right;
                if (current == null) {
                    parent.right = newNode;
                    return;
                }
            }
        }
    }
}
