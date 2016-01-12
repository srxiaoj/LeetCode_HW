import org.omg.CosNaming._BindingIteratorImplBase;

public class Delete {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        /**
         *                 6
         *              /    \
         *             2      8
         *            / \    /  \
         *           0   4  7    9
         *              / \
         *             3   5 
         */
        TreeNode parentOfRoot = new TreeNode(Integer.MAX_VALUE);
        
        TreeNode root = new TreeNode(6);
        parentOfRoot.left = root;
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);
//        root.printTree(parentOfRoot.left);
//        System.out.println("");
//        delete(parentOfRoot, 6);
//        root.printTree(parentOfRoot.left);
        System.out.println("******");
        /**
         * java is pass by value, so root's value will not be deleted
         * if order to fix this, we need a header to point to the head of
         * the root, then print out this pointer
         */
        System.out.println("******");
        root.printTreeInOrder(root);
        System.out.println("");
        delete(parentOfRoot, 6);
        root.printTreeInOrder(root);
    }
    public static boolean delete(TreeNode root, int key) {
        TreeNode current = root;
        TreeNode parent = root;
        boolean isLeftChild = true;
        
        while (current.val != key) {
            parent = current;
            if (key < current.val) {
                isLeftChild = true;
                current = current.left;
            } else {
                isLeftChild = false;
                current = current.right;
            }
            if (current == null) return false;
        }
        /**
         *  found the node
         */
        // no child
        if (current.left == null && current.right == null) {
            if (current == root) {
                root = null;
            } else if (isLeftChild) {
                parent.left = null;
            } else {
                parent.right = null;
            }
        // one child    
        } else if (current.right == null) {
            if (current == root) {
                root = current.left;
            } else if (isLeftChild) {
                parent.left = current.left;
            } else {
                parent.right = current.right;
            }
        } else if (current.left == null) {
            if (current == root) {
                root = current.right;
            } else if (isLeftChild) {
                parent.left = current.left;
            } else {
                parent.right = current.right;
            }
        // two children
        } else {
            TreeNode successor = getSuccessor(current);
//            System.out.println("current value is: " + current.val);
            if (current == root)
                root = successor;
            else if (isLeftChild)
                parent.left = successor;
            else
                parent.right = successor;
//            System.out.println("current.left value is: " + current.left.val);
            successor.left = current.left;
        }
        return true;
    }
    private static TreeNode getSuccessor(TreeNode delNode) {
        TreeNode successorParent = delNode;
        TreeNode succesor = delNode;
        TreeNode current = delNode.right;
        while (current != null) {
            successorParent = succesor;
            succesor = current;
            current = current.left;
        }
        if (succesor != delNode.right) {
            successorParent.left = succesor.right; // move successor.right to successorparent.left
            succesor.right = delNode.right; // connect successor with original delNode.right
        }
        System.out.println("succesor value is: " + succesor.val);
        return succesor;
    }
}
