import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class MaxTree {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
//        int[] a = new int[] {2, 5, 7, 1, 4, 3};
        int[] a = new int[] {2,5,6,1,2,1,3,0,7};
//        int[] a = new int[] {2, 5, 16, 1, 2, 9, 3, 7, 8, 4};
        MaxTree obj = new MaxTree();
        TreeNode res = obj.maxTree(a);
        TreeNode.printNode(res);
        
//        System.out.println("Tree test:");
//        TreeNode root = new TreeNode(6);
//        root.left = new TreeNode(5);
//        root.left.left = new TreeNode(2);
//        root.right = new TreeNode(4);
//        root.right.left = new TreeNode(3);
//        root.right.left.left = new TreeNode(1);
//        root.right.left.right = new TreeNode(2);
//        root.printTreeInOrder(root);
        
    }
    public TreeNode maxTree(int[] a) {

        int[] preorder = a.clone();
        int[] inorder = a.clone();
        Arrays.sort(inorder);
        Map<Integer, Integer> map = new HashMap<>();
        Stack<TreeNode> stack = new Stack<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        TreeNode root = null;
        TreeNode cur = null;
        for (int i = 0; i < preorder.length; i++) {
            if (root != null && cur != null) {
//                System.out.println("root is: " + root.val);
//                System.out.println("cur is: " + cur.val);
            }
            TreeNode node = new TreeNode(preorder[i]);
            int pos = map.get(preorder[i]);
            if (stack.isEmpty()) {
                stack.add(node);
                root = node;
                cur = node;
                continue;
            }
            if (pos > map.get(stack.peek().val)) {
                while (!stack.isEmpty() && pos > map.get(stack.peek().val)) {
                    cur = stack.pop();
                    node.left = cur;
                }
                if (stack.isEmpty()) { // new root is found
                    node.left = root;
                    root = node;
                    cur = node;
                } else {
                    cur = stack.peek();
                    cur.right = node;
                    cur = node;
                }

            } else {
                cur.right = node;
                cur = node;
            }
            stack.add(node);
        }

        return root;

        //        int len = a.length;
//        TreeNode[] stk = new TreeNode[len];
//        for (int i = 0; i < len; ++i)
//            stk[i] = new TreeNode(0);
//        int cnt = 0;
//        for (int i = 0; i < len; ++i) {
//            TreeNode tmp = new TreeNode(a[i]);
//            while (cnt > 0 && a[i] > stk[cnt-1].val) {
//                tmp.left = stk[cnt-1];
//                cnt --;
//            }
//            if (cnt > 0)
//                stk[cnt - 1].right = tmp;
//            stk[cnt++] = tmp;
//        }
//        return stk[0];
    }
}
