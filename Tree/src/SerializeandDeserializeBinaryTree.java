import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class SerializeandDeserializeBinaryTree {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        /**
         *                 6
         *              /    \
         *             2      8
         *            / \    /  \
         *           0   4  7    9
         *              / \     / \
         *             3   5   13  15 
         */
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);
        root.right.right.left = new TreeNode(13);
        root.right.right.right = new TreeNode(15);
        SerializeandDeserializeBinaryTree codec = new SerializeandDeserializeBinaryTree();
        String serial = codec.serializePreorder(root);
        System.out.println(serial);
        System.out.println("***********");
        TreeNode reversedRoot = codec.deserializeLevelorder(serial);
        System.out.println(codec.serializeLevelorder(reversedRoot));
        
        
//        TreeNode test2 = new TreeNode(1);
//        System.out.println(codec.serialize3(test2));
        // SerializeandDeserializeBinaryTree.deserialize(SerializeandDeserializeBinaryTree.serialize(root));
        
        
        System.out.println("***********");
        String testString = "6,2,8,0,4,7,9,null,null,3,5,null,null,13,15";
        TreeNode testRoot = codec.deserializeLevelorder(testString);
        testRoot.printTreeInOrder(testRoot);
    }
    private static final String SPLITTER = ",";
    private static final String NN = "null";
    /**
     * Encodes a tree to a single string, preorder traversal.
     * @param root
     * @return
     */
    public String serializePreorder(TreeNode root) {
        
        // method 1: preorder traversal
        StringBuilder sb = new StringBuilder();
        buildString(root, sb);
        sb.deleteCharAt(sb.length() - 1); // delete the last splitter
        System.out.println("The total number of nodes is in serializePreOrder: " + sb.toString().split(",").length);
        return sb.toString();
    }    
    private void buildString(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append(NN).append(SPLITTER);
        } else {
            sb.append(node.val).append(SPLITTER);
            buildString(node.left, sb);
            buildString(node.right,sb);
        }
    }
    /**
     * print out the tree as a complete tree. 2^(h+1) - 1, has bug
     * @param root
     * @return
     */
    public String serialize2(TreeNode root) {
        
        // method 2: level order traversal
        if (root == null) return "";
        int  level= height(root);
//        System.out.println("height is: " + level);
        int arrayLength = (int) Math.pow(2, level) - 1;
//        System.out.println("arraylength is: " + arrayLength);
        TreeNode[] list = new TreeNode[arrayLength];
        Arrays.fill(list, null);
        list[0] = root;
        String[] res = new String[arrayLength];
        res[0] = String.valueOf(root.val);
        
        for (int i = 1; i <= arrayLength / 2; i++) {
            if (list[i - 1] != null) {
                list[2 * i - 1]= list[i - 1].left;
                list[2 * i] = list[i - 1].right;
            } else {
                list[2 * i - 1] = null;
                list[2 * i] = null;
            }
        }
        for (int i = 0; i < arrayLength; i++) {
            if (list[i] == null) {
                res[i] = null;
            } else {
                res[i] = String.valueOf(list[i].val);
            }
        }
        return Arrays.toString(res);
    }
    /**
     * Encodes a tree to a single string, level order traversal.
     * @param root
     * @return
     */
    public String serializeLevelorder(TreeNode root) {
        // method 3: level order traversal
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
    
    public TreeNode deserialize2(String data) {
        
        // method 2: level order traversal
        if (data.length() == 0) return null;
        data = data.substring(1,data.length()-1); // get rid of the "[" and "]"
        data = data.replaceAll("\\s", ""); // get rid of the space
        String[] dataArray = data.split(",");
//        printArray(dataArray);
        int arrayLength = dataArray.length;
        TreeNode root = new TreeNode(Integer.parseInt(dataArray[0]));
        TreeNode[] list = new TreeNode[arrayLength];
        list[0] = root;
        for (int i = 1; i < arrayLength; i++) {
            if (!dataArray[i].equals("null")) {
                list[i] = new TreeNode(Integer.parseInt(dataArray[i]));
            } else {
                list[i] = null;
            }
        }
        for (int i = 1; i <= arrayLength / 2; i++) {
            if (list[i - 1] != null) {
                list[i - 1].left = list[2 * i - 1];
                list[i - 1].right = list[2 * i];
            }
        }
        return root;
        
    }
    /**
     * Decodes your encoded data to tree, level order traversal 
     * @param data
     * @return
     */
    public TreeNode deserializeLevelorder(String data) {
        // method 3
        String[] nodes = data.split("\\,");
        System.out.println("The total number of nodes is in level order deserial: " + nodes.length);
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
