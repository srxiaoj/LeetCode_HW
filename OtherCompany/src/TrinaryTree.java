public class TrinaryTree {
    class Node {
        Node left;
        Node right;
        Node middle;
        int val;

        Node(int val) {
            this.val = val;
        }
    }

    Node root;

    public TrinaryTree() {
        this.root = null;
    }

    public TrinaryTree(Node root) {
        this.root = root;
    }

    //insertHelper a value to the appropriate position in the tree.
    public void insert(int val) {
        if (root != null) {
            root = insertHelper(root, val);
        } else {
            root = new Node(val);
        }
    }

    public Node insertHelper(Node node, int val) {
        if (node == null) {
            node = new Node(val);
        } else if (val < node.val) {
            node.left = insertHelper(node.left, val);
        } else if (val == node.val) {
            node.middle = insertHelper(node.middle, val);
        } else {
            node.right = insertHelper(node.right, val);
        }
        return node;
    }

    //deleteHelper a value from the tree.
    public void delete(int val) {
        root = deleteHelper(root, val);
    }

    public Node deleteHelper(Node node, int val) {
        if (node == null) {
            System.out.println("The node " + val + " doesn't exist");
            return null;
        } else if (val < node.val) {
            node.left = deleteHelper(node.left, val);
        } else if (val > node.val) {
            node.right = deleteHelper(node.right, val);
        } else {
            if (node.middle != null) {
                node.middle = deleteHelper(node.middle, val);
            } else if (node.right != null) {
                node.val = getMin(node.right).val;
                node.right = deleteHelper(node.right, getMin(node.right).val);
            } else {
                node = node.left;
            }
        }
        return node;
    }

    // find min as helper function to deleteHelper
    private Node getMin(Node node) {
        if (node != null) {
            while (node.left != null) {
                node = node.left;
            }
        }
        return node;
    }

    // pre-order traverse the tree and print the value
    public void print(Node root) {
        if (root == null) return;
        if (root != null) {
            System.out.println("Node value: " + root.val);
            print(root.left);
            print(root.middle);
            print(root.right);
        }
    }

    public void print() {
        print(root);
    }

    public static void main(String[] args) {
        TrinaryTree tree = new TrinaryTree();
        tree.insert(5);
        tree.insert(4);
        tree.insert(9);
        tree.insert(5);
        tree.insert(7);
        tree.insert(2);
        tree.insert(2);
        //preorder traversal, the sequence should be 5422597
        System.out.println("Preorder traversal: ");
        tree.print();
        tree.delete(5);
        tree.delete(7);
        tree.delete(5);
        tree.delete(4);
        // the sequence should be 542297
        System.out.println("After deleteHelper 5:");
        tree.print();
        // deleteHelper a node not exited
        tree.delete(10);
        System.out.println("After deleteHelper 10:");
    }
}