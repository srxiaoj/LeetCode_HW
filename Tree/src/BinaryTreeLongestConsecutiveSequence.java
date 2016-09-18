public class BinaryTreeLongestConsecutiveSequence {

    public static void main(String[] args) {
        BinaryTreeLongestConsecutiveSequence obj = new BinaryTreeLongestConsecutiveSequence();
        /**
         *         1
         *          \
         *           3
         *          / \
         *         2   4
         *              \
         *               5
         */
        TreeNode root1 = TreeNode.deserializeLevelorder("1,null,3,2,4,null,null,null,5");
//        System.out.println(obj.longestConsecutive4(root1));

        TreeNode c = TreeNode.deserializeLevelorder("2,null,3,2,null,1,null");
//        TreeNode.printNode(c);
        System.out.println(obj.longestConsecutive4(c));
    }


    /**
     * 判断parent与child关系，如果parent.val == child.val - 1，则localMax + 1,且不断update globalMax
     * @param root
     * @return
     */
    public int longestConsecutive2(TreeNode root) {
        if (root == null) return 0;
        int[] max = new int[1];
        max[0] = 1;
        helper(root, root.left, max, 1);
        helper(root, root.right, max, 1);
        return max[0];
    }

    public void helper(TreeNode parent, TreeNode node, int[] max, int localMax) {
        if (node == null) return;
        if (parent.val == node.val - 1) {
            localMax++;
        } else {
            localMax = 1;
        }
        if (max[0] < localMax) {
            max[0] = localMax;
        }
        helper(node, node.left, max, localMax);
        helper(node, node.right, max, localMax);
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


    // method 3
    public int longestConsecutive3(TreeNode root) {
        Pair cur = new Pair(root, 1);
        if (root == null) return 0;
        helper(null, cur);
        return globalmax;
    }

    private int globalmax = 1;
    private void helper(Pair last, Pair cur) {
        if (cur == null || cur.node == null) return;
        if (last != null && cur.node.val == last.node.val + 1) {
            cur.count = last.count + 1;
            globalmax = Math.max(cur.count, globalmax);
        }

        if (cur.node.left != null) {
            helper(cur, new Pair(cur.node.left, 1));
        }
        if (cur.node.right != null) {
            helper(cur, new Pair(cur.node.right, 1));
        }
    }

    class Pair {
        TreeNode node;
        int count;
        public Pair(TreeNode node, int c) {
            this.node = node;
            this.count = c;
        }
    }

    // method 4
    int myGlobalMax;
    public int longestConsecutive4(TreeNode root) {
        myGlobalMax = 0;
        helper(root);
        return myGlobalMax;
    }

    private int helper(TreeNode node) {
        if (node == null) return 0;
        int max = 1;
        int left = helper(node.left);
        int right = helper(node.right);
        if (left != 0 && node.val == node.left.val - 1) {
            max = Math.max(max, left + 1);
        }
        if (right != 0 && node.val == node.right.val - 1) {
            max = Math.max(max, right + 1);
        }
        myGlobalMax = Math.max(max, myGlobalMax);
        return max;
    }
}
