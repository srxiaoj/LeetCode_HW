import org.omg.IOP.Codec;

public class BinaryTreeLongestConsecutiveSequence {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        /**
         *         1
         *          \
         *           3
         *          / \
         *         2   4
         *              \ 
         *               5
         */
        BinaryTreeLongestConsecutiveSequence obj = new BinaryTreeLongestConsecutiveSequence();
        SerializeandDeserializeBinaryTree codec = new SerializeandDeserializeBinaryTree();
//        TreeNode a = new TreeNode(1);
//        a.right = new TreeNode(3);
//        a.right.left = new TreeNode(2);
//        a.right.right = new TreeNode(4);
//        a.right.right.right = new TreeNode(5);
//        a.printTree(a);
//        System.out.println("");
//        System.out.println(obj.longestConsecutive(a));

//        String bStr = "2,null,3,2,null,1,null";
//        SerializeandDeserializeBinaryTree codec = new SerializeandDeserializeBinaryTree();
//        TreeNode b = codec.deserialize(bStr);
//        b.printTree(b);
//        System.out.println("");
//        System.out.println(obj.longestConsecutive(b));
        
        /**
         *         1
         *        / 
         *       2  
         *      /   
         *     1      
         *    / \         
         *   7   2         
         */
        TreeNode c = new TreeNode(1);
        c.left = new TreeNode(2);
        c.left.left = new TreeNode(1);
        c.left.left.left = new TreeNode(7);
        c.left.left.right = new TreeNode(2);
        System.out.println(obj.longestConsecutive(c));
        System.out.println(codec.serializeLevelorder(c));
        c.inorderRecursive(c);
    }
    private int max = 0;
    private TreeNode rt = null;
    public int longestConsecutive(TreeNode root) {
        /*
        //method 1
        int left = 0, right = 0;
        if (root == null) return 0;
        if (root.left == null && root.right == null) {
            return 1;
        }
        if(rt == null)  rt = root;
        if (root.right != null) {
            if (root.right.val == root.val + 1) {
                right = longestConsecutive(root.right) + 1;
            } else {
                right = 1;
                longestConsecutive(root.right);
            }
        }
        if (root.left != null) {
            if (root.left.val == root.val + 1) {
                left = longestConsecutive(root.left) + 1;
            } else {
                left = 1; //reset left value
                longestConsecutive(root.left);
            }
        }
        max = Math.max(max, Math.max(left, right));
        return rt == root ? max : Math.max(right, left);
        */
        
        //method 2
        if(root == null) return 0;
        helper(root, 0, root.val);
        return max;
    }

    public void helper(TreeNode root, int count, int target){
        if(root == null) return;
        if(root.val == target) count++;
        else count = 1;
        max = Math.max(count, max);
        helper(root.left, count, root.val + 1);
        helper(root.right, count, root.val + 1);
    }
}
