import java.util.*;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode parent;
    TreeNode (int x) { val = x; }


    /**
     * print tree with in order traversal.
     */
    public static void printTreeInOrder(TreeNode root) {
        if (root != null) {
            printTreeInOrder(root.left);
            System.out.print(root.val + " ");
            printTreeInOrder(root.right);
        }
    }
    /**
     * Decodes your encoded data to tree, level order traversal
     * @param data
     * @return
     */
    private static final String NN = "null";
    public static TreeNode deserializeLevelorder(String data) {
        // method 2
        String[] nodes = data.split("\\,");
//        System.out.println("The total number of nodes is in level order deserial: " + nodes.length);
        if (nodes.length == 1) return null;

        TreeNode root = new TreeNode(Integer.parseInt(nodes[0].trim()));
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int i = 1;           // starting from the second node if root is not null

        while (i < nodes.length) {
            TreeNode node = queue.poll();

            String left = nodes[i++].trim(), right = nodes[i++].trim();
            if (!left.equals(NN)) {
                TreeNode lChild = new TreeNode(Integer.parseInt(left));
                node.left = lChild;
                queue.offer(lChild);
            }
            if (!right.equals(NN)) {
                TreeNode rChild = new TreeNode(Integer.parseInt(right));
                node.right = rChild;
                queue.offer(rChild);
            }
        }
        return root;
    }
    public int height(TreeNode root) {
        if (root == null) return 0;
        return Math.max(height(root.left), height(root.right)) + 1;
    }
    
    /**
     * recursive, no return.
     * @param root
     */
    public static void inorderRecursive(TreeNode root) {
        if (root != null) {
            inorderRecursive(root.left);
            System.out.print(root.val + " ");
            inorderRecursive(root.right);
        }
    }
    
    /**
     * recursive, no return.
     * @param root
     */
    public static void preorderRecursive(TreeNode root) {
        if (root != null) {
            System.out.print(root.val + " ");
            preorderRecursive(root.left);
            preorderRecursive(root.right);
        }
    }
    
    /**
     * recursive, no return.
     * @param root
     */
    public static void postorderRecursive(TreeNode root) {
        if (root != null) {
            postorderRecursive(root.left);
            postorderRecursive(root.right);
            System.out.print(root.val + " ");
        }
    }

    public static void printNode(TreeNode root) {
        int maxLevel = maxLevel(root);
        printNodeInternal(Collections.singletonList(root), 1, maxLevel);
    }

    private static void printNodeInternal(List<TreeNode> nodes, int level, int maxLevel) {
        if (nodes.isEmpty() || isAllElementsNull(nodes))
            return;

        int floor = maxLevel - level;
        int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
        int firstSpaces = (int) Math.pow(2, (floor)) - 1;
        int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

        printWhitespaces(firstSpaces);

        List<TreeNode> newNodes = new ArrayList<TreeNode>();
        for (TreeNode node : nodes) {
            if (node != null) {
                System.out.print(node.val);
                newNodes.add(node.left);
                newNodes.add(node.right);
            } else {
                newNodes.add(null);
                newNodes.add(null);
                System.out.print(" ");
            }

            printWhitespaces(betweenSpaces);
        }
        System.out.println("");

        for (int i = 1; i <= endgeLines; i++) {
            for (int j = 0; j < nodes.size(); j++) {
                printWhitespaces(firstSpaces - i);
                if (nodes.get(j) == null) {
                    printWhitespaces(endgeLines + endgeLines + i + 1);
                    continue;
                }

                if (nodes.get(j).left != null)
                    System.out.print("/");
                else
                    printWhitespaces(1);

                printWhitespaces(i + i - 1);

                if (nodes.get(j).right != null)
                    System.out.print("\\");
                else
                    printWhitespaces(1);

                printWhitespaces(endgeLines + endgeLines - i);
            }

            System.out.println("");
        }

        printNodeInternal(newNodes, level + 1, maxLevel);
    }

    private static void printWhitespaces(int count) {
        for (int i = 0; i < count; i++)
            System.out.print(" ");
    }

    private static  int maxLevel(TreeNode node) {
        if (node == null)
            return 0;

        return Math.max(maxLevel(node.left), maxLevel(node.right)) + 1;
    }

    private static boolean isAllElementsNull(List<TreeNode> list) {
        for (TreeNode object : list) {
            if (object != null)
                return false;
        }

        return true;
    }

    public String toString() {
        String leftString = (left == null) ? "null" : ("" + left.val);
        String rightString = (right == null) ? "null" : ("" + right.val);
        String output = "" + val + " (" + leftString + "," + rightString + ")";
        return output;
    }
}
