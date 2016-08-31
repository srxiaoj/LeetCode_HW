import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class ClosestBinarySearchTreeValueII {

    public static void main(String[] args) {
        ClosestBinarySearchTreeValueII obj = new ClosestBinarySearchTreeValueII();
        TreeNode root = TreeNode.deserializeLevelorder("6,2,8,0,4,7,9,null,null,3,5");
        TreeNode.printNode(root);
        System.out.println(obj.closestKValues(root, 3.2, 4));
    }

    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> res = new LinkedList<>();
        Stack<TreeNode> succ = new Stack<>();
        Stack<TreeNode> pred = new Stack<>();
        initializePredecessorStack(root, target, pred);
        initializeSuccessorStack(root, target, succ);
        if (!succ.isEmpty() && !pred.isEmpty() && succ.peek().val == pred.peek().val) {
            getNextPredecessor(pred);
        }
        while (k-- > 0) {
            if (succ.isEmpty()) {
                res.add(getNextPredecessor(pred));
            } else if (pred.isEmpty()) {
                res.add(getNextSuccessor(succ));
            } else {
                double succ_diff = Math.abs((double) succ.peek().val - target);
                double pred_diff = Math.abs((double) pred.peek().val - target);
                if (succ_diff < pred_diff) {
                    res.add(getNextSuccessor(succ));
                } else {
                    res.add(getNextPredecessor(pred));
                }
            }
        }
        return res;
    }

    private void initializeSuccessorStack(TreeNode root, double target, Stack<TreeNode> succ) {
        while (root != null) {
            if (root.val == target) {
                succ.push(root);
                break;
            } else if (root.val > target) {
                succ.push(root);
                root = root.left;
            } else {
                root = root.right;
            }
        }
    }

    private void initializePredecessorStack(TreeNode root, double target, Stack<TreeNode> pred) {
        while (root != null) {
            if (root.val == target) {
                pred.push(root);
                break;
            } else if (root.val < target) {
                pred.push(root);
                root = root.right;
            } else {
                root = root.left;
            }
        }
    }

    private int getNextSuccessor(Stack<TreeNode> succ) {
        TreeNode cur = succ.pop();
        int value = cur.val;
        cur = cur.right;
        while (cur != null) {
            succ.push(cur);
            cur = cur.left;
        }
        return value;
    }

    private int getNextPredecessor(Stack<TreeNode> pred) {
        TreeNode cur = pred.pop();
        int value = cur.val;
        cur = cur.left;
        while (cur != null) {
            pred.push(cur);
            cur = cur.right;
        }
        return value;
    }
}
