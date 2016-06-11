import java.util.*;

public class SerializeandDeserializeBinaryTree {
    public static void main(String[] args) {
        /**
         *                 6
         *              /    \
         *             2      8
         *            / \    /  \
         *           0   4  7    9
         *              / \     / \
         *             3   5   13  15 
         */
        SerializeandDeserializeBinaryTree codec = new SerializeandDeserializeBinaryTree();
        TreeNode root = TreeNode.deserializeLevelorder("6,2,8,0,4,7,9,null,null,3,5,null,null,13,15");
        TreeNode.printNode(root);

        /*String afterSerialize = codec.serializeLevelorder(root);
        System.out.println("after levelorder Serialize: " + afterSerialize);
        TreeNode afterDeserialize = codec.deserializeLevelorder(afterSerialize);*/

        System.out.println("-----------------------");
        String serial = codec.serializePreorder(root);
        System.out.println("after preorder Serialize: " + serial);
        TreeNode afterDeserialize2 = codec.deserializePreorder(serial);
        TreeNode.printNode(afterDeserialize2);

    }

    private static final String SPLITTER = ",";
    private static final String NN = "null";

    /**
     * Encodes a tree to a single string, preorder traversal, recursive
     */
    public String serializePreorder(TreeNode root) {

        // method 1: preorder traversal
        StringBuilder sb = new StringBuilder();
        serializeRecursive(root, sb);
        sb.deleteCharAt(sb.length() - 1); // delete the last splitter
        System.out.println("The total number of nodes is in serializePreOrder: " + sb.toString().split(",").length);
        return sb.toString();
    }

    private void serializeRecursive(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append(NN).append(SPLITTER);
        } else {
            sb.append(node.val).append(SPLITTER);
            serializeRecursive(node.left, sb);
            serializeRecursive(node.right, sb);
        }
    }

    /**
     * Decodes your encoded data to tree, preorder traversal
     */
    public TreeNode deserializePreorder(String data) {
        System.out.println(data);
        String[] tokens = data.split(SPLITTER);
        List<String> list = new ArrayList<>(Arrays.asList(tokens));
        int[] index = new int[1];
//        TreeNode root = helper(list);
        TreeNode root = helper(list, index);
        return root;
    }
    private TreeNode helper(List<String> list, int[] index) {
        if (list.size() > 0) {
            String next = list.get(0);
            list.remove(0);
            if (next.equals(NN)) {
                return null;
            }
            TreeNode node = new TreeNode(Integer.parseInt(next));
            node.left = helper(list);
            node.right = helper(list);
            return node;
        } else {
            return null;
        }
    }
    private TreeNode helper(List<String> list) {
        if (list.size() > 0) {
            String next = list.get(0);
            list.remove(0);
            if (next.equals(NN)) {
                return null;
            }
            TreeNode node = new TreeNode(Integer.parseInt(next));
            node.left = helper(list);
            node.right = helper(list);
            return node;
        } else {
            return null;
        }
    }

    /**
     * Encodes a tree to a single string, level order traversal, iterative.
     */
    public String serializeLevelorder(TreeNode root) {
        if (root == null) return NN;
        int height = height(root);
        int numOfNodes = (int) Math.pow(2, height) - 1;

        StringBuilder res = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);

        int i = 0;
        while (!queue.isEmpty() && i < numOfNodes) {
            TreeNode node = queue.poll();
            if (node == null) {
                res.append(NN + ",");
            } else {
                res.append(node.val).append(',');
                queue.offer(node.left);
                queue.offer(node.right);
            }
            i++;
        }
        res.deleteCharAt(res.length() - 1);
        System.out.println("The total number of nodes is in level order serial: " + res.toString().split(",").length);
        return res.toString();
    }

    /**
     * Decodes your encoded data to tree, level order traversal
     */
    public TreeNode deserializeLevelorder(String data) {
        String[] nodes = data.split("\\,");
//        System.out.println("The total number of nodes is in level order deserial: " + nodes.length);
        if (nodes.length == 1) return null;

        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int i = 1;           // starting from the second node if root is not null
        while (i < nodes.length) {
            TreeNode node = queue.poll();
            String left = nodes[i++], right = nodes[i++];
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

    //print array
    public static void printArray(String[] A) {
        for (int i = 0; i < A.length; i++) {
            if (i != A.length - 1)
                System.out.print(A[i] + ", ");
            else
                System.out.print(A[i]);
        }
        System.out.println("");
    }
}
