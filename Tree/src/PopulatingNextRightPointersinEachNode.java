/**
 * Created by thanksgiving on 2/27/16.
 */
public class PopulatingNextRightPointersinEachNode {
    public void connect(TreeLinkNode root) {
        if (root == null) return;
        TreeLinkNode horizon = root;
        while (horizon.left != null) {
            TreeLinkNode left = horizon.left;
            while (horizon != null) {
                horizon.left.next = horizon.right;
                if (horizon.next != null) {
                    horizon.right.next = horizon.next.left;
                }
                horizon = horizon.next;
            }
            horizon = left;
        }

        /*if (root == null) return;
        Stack<List<TreeLinkNode>> stack = new Stack<>();
        List<TreeLinkNode> rootList = new ArrayList<>();
        rootList.add(root);
        stack.push(rootList);

        while (!stack.isEmpty()) {
            List<TreeLinkNode> lastList = stack.pop();
            // point each node in last list to its next element except the last one
            for (int i = 0; i < lastList.size() - 1; i++) {
                lastList.get(i).next = lastList.get(i + 1);
            }
            List<TreeLinkNode> nextList = new ArrayList<>();
            for (TreeLinkNode node : lastList) {
                if (node.left != null) {
                    nextList.add(node.left);
                }
                if (node.right != null) {
                    nextList.add(node.right);
                }
            }
            if (!nextList.isEmpty()) {
                stack.push(nextList);
            }
        }*/
    }

    private class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;
        TreeLinkNode(int x) {
            val = x;
        }
    }
}
