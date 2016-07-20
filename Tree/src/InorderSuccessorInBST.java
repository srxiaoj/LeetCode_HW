public class InorderSuccessorInBST {

    public static void main(String[] args) {
        /**
         *                 6
         *              /    \
         *             2      8
         *            / \    /  \
         *           0   4  7    9
         *              / \
         *             3   5 
         */
        TreeNode root = TreeNode.deserializeLevelorder("6, null, 8, 7, 9");
        TreeNode p = TreeNode.deserializeLevelorder("2, 0, 4, null, null, 3, 5");
        root.left = p;

        TreeNode res = inorderSuccessor(root, p);
        TreeNode.printNode(res);
    }

    public static TreeNode inorderSuccessorWithParent(TreeNode root, TreeNode p) {
        if (p.right != null) {
            return minValue(p.right);
        }

        while (p.parent != null && p.parent.val < p.val) {
            p = p.parent;
        }
        return p.parent;
    }

    private static TreeNode minValue(TreeNode node) {
        TreeNode cur = node;
        while (cur.left != null) {
            cur = cur.left;
        }
        return cur;
    }

    public static TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode succ = null;
        while (root != null) {
            if (p.val < root.val) {
                succ = root;
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return succ;

     /*   List<TreeNode> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        boolean isEqual = false;
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode curNode = stack.lastElement();
            if (curNode.left != null) {
                stack.add(curNode.left);
                curNode.left = null;
            } else {
                list.add(curNode);
                if (isEqual) {
                    return curNode;
                } else {
                    if (curNode.equals(p)) {
                        isEqual = true;
                    }
                }
                stack.pop();
                if (curNode.right != null) {
                    stack.add(curNode.right);
                }
            }
        }
        return null;*/
    }
}
