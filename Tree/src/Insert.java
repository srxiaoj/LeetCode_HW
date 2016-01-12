
public class Insert {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        TreeNode root = new TreeNode(15);
        root.left = new TreeNode(8);
        root.right = new TreeNode(20);
        root.left.left = new TreeNode(5);
        root.right.left = new TreeNode(17);
        root.right.left.left = new TreeNode(16);
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
