import java.util.Stack;

/**
 * Created by thanksgiving on 1/30/16.
 */
public class BinarySearchTreeIterator {
    public static void main(String[] args) {

//        Your BSTIterator will be called like this:
        TreeNode root = TreeNode.deserializeLevelorder("8, 5, 12, 1, 7, null, null, null, null, 6, null");
        BSTIterator i = new BSTIterator(root);
        while (i.hasNext()) {
            System.out.print(i.next() + ",");
        }

    }
}

class BSTIterator {
    private Stack<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        pushAll(root);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        if (hasNext()) {
            TreeNode last = stack.pop();
            pushAll(last.right);
            return last.val;
        }
        return -1;
    }

    private void pushAll(TreeNode node) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }
}
