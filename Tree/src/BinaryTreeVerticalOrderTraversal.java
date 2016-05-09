import java.util.*;

public class BinaryTreeVerticalOrderTraversal {

    public static void main(String[] args) {
        TreeNode a = TreeNode.deserializeLevelorder("3,9,30,null,null,15,7");
        BinaryTreeVerticalOrderTraversal obj = new BinaryTreeVerticalOrderTraversal();
        List<List<Integer>> res = obj.verticalOrder(a);
        printTwoDArrayList(res);
        System.out.println("*********************");
//
        TreeNode b = TreeNode.deserializeLevelorder("3,9,8,4,0,1,7,null,null,null,2,5,null");
        TreeNode.printNode(b);
        List<List<Integer>> res2 = obj.verticalOrder(b);
        printTwoDArrayList(res2);
        System.out.println("*********************");
    }


    /**
     * 使用一个map 存每个col有多少node
     * 使用一个map 存每个node的位置
     * 需要用bfs，不能使用dfs
     */
    public List<List<Integer>> verticalOrder(TreeNode root) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        Map<TreeNode, Integer> pos = new HashMap<>();
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        pos.put(root, 0);

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            int curPos = pos.get(node);
            // update map
            List<Integer> sub;
            if (!map.containsKey(curPos)) {
                sub = new ArrayList<>();
            } else {
                sub = map.get(curPos);
            }
            sub.add(node.val);
            map.put(curPos, sub);

            if (node.left != null) {
                queue.offer(node.left);
                pos.put(node.left, curPos - 1);
            }
            if (node.right != null) {
                queue.offer(node.right);
                pos.put(node.right, curPos + 1);
            }
        }

        TreeMap<Integer, List<Integer>> treeMap = new TreeMap<>(map);
        for (Map.Entry entry : treeMap.entrySet()) {
            res.add((List<Integer>) entry.getValue());
        }
        return res;
    }
    //print two dimensional array list, which can also be replaced by simply System.out.println(A)
    public static void printTwoDArrayList(List<List<Integer>> A) {
        for (int i = 0; i < A.size(); i++) {

            System.out.print(A.get(i) + " ");
            System.out.println("");
        }

    }
}
