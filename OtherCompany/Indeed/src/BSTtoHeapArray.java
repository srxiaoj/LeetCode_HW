import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by thanksgiving on 10/29/16.
 */
public class BSTtoHeapArray {
    public static void main(String[] args) {
        TreeNode root = TreeNode.deserializeLevelorder("15,8,20,5,null,17,null,null,null,16,null");
        TreeNode.printNode(root);
        printArray(BSTtoArray(root));
    }

    public static Integer[] BSTtoArray(TreeNode root) {
        int n = 2 << height(root);
        Integer[] nums = new Integer[n];
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(0, root));
        while (!queue.isEmpty()) {
            Pair last = queue.poll();
            nums[last.index] = last.node.val;
            if (last.node.left != null) {
                queue.add(new Pair(2 * last.index + 1, last.node.left));
            }

            if (last.node.right != null) {
                queue.add(new Pair(2 * last.index + 2, last.node.right));
            }
        }
        return nums;
    }

    static class Pair {
        int index;
        TreeNode node;
        public Pair(int index, TreeNode node) {
            this.index = index;
            this.node = node;
        }
    }

    public static int height(TreeNode root) {
        if (root == null) return 0;
        return 1 + height(root.left);
    }


    //print array
    public static void printArray(Integer[] A) {
        System.out.print("[");
        for (int i = 0; i < A.length; i++) {
            if (i != A.length - 1)
                System.out.print(A[i] + ", ");
            else
                System.out.print(A[i]);
        }
        System.out.println("]");
    }
}
