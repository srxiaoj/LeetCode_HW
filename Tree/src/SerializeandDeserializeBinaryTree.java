import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

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


        /**
         * level serialization
         */
        String afterSerialize = codec.serializeLevelorder(root);
        System.out.println("after levelorder Serialize: " + afterSerialize);
        TreeNode afterDeserialize = codec.deserializeLevelorder(afterSerialize);
//        System.out.println("after levelorder Deserialize: ");
//        TreeNode.printNode(afterDeserialize);

        /**
         * preorder serialization
         */
        System.out.println("-----------------------");
        String serial = codec.serializePreorder(root);
        System.out.println("after preorder Serialize: " + serial);

    }
    private static final String SPLITTER = ",";
    private static final String NN = "null";
    /**
     * Encodes a tree to a single string, preorder traversal, recursive
     * @param root
     * @return
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
            serializeRecursive(node.right,sb);
        }
    }
    /**
     * Encodes a tree to a single string, level order traversal, iterative.
     * @param root
     * @return
     */
    public String serializeLevelorder(TreeNode root) {
        // method 2: level order traversal
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
            }
            else {
                res.append(node.val).append(',');
                queue.offer(node.left);
                queue.offer(node.right);
            }
            i++;
        }
        res.deleteCharAt(res.length()-1);
        System.out.println("The total number of nodes is in level order serial: " + res.toString().split(",").length);
        return res.toString();
    }
    
    /**
     * Decodes your encoded data to tree, preorder traversal 
     * @param data
     * @return
     */
    public TreeNode deserializePreorder(String data) {
        
        // method 1: preorder traversal
        Deque<String> nodes = new LinkedList<>();
        nodes.addAll(Arrays.asList(data.split(SPLITTER)));
//        System.out.println("node is: " + nodes);
        return buildTree(nodes);
    }
    private TreeNode buildTree(Deque<String> nodes) {
        String val = nodes.remove();
//        System.out.println("val is: " + val);
        if (val.equals(NN)) return null;
        else {
            TreeNode node = new TreeNode(Integer.valueOf(val));
            node.left = buildTree(nodes);
            node.right = buildTree(nodes);
            return node;
        }
    }
    
    /**
     * Decodes your encoded data to tree, level order traversal 
     * @param data
     * @return
     */
    public TreeNode deserializeLevelorder(String data) {
        // method 2
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
    public static void printArray(String[] A)
    {
        for(int i = 0; i < A.length; i++)
        {
            if(i != A.length-1)
                System.out.print(A[i] + ", ");
            else
                System.out.print(A[i]);
        }
        System.out.println("");
    }
}
