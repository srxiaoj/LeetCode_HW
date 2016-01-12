import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class BinaryTreeVerticalOrderTraversal {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        TreeNode a = new TreeNode(3);
        a.left = new TreeNode(9);
        a.right = new TreeNode(20);
        a.right.left = new TreeNode(15);
        a.right.right = new TreeNode(7);
        BinaryTreeVerticalOrderTraversal obj = new BinaryTreeVerticalOrderTraversal();
        List<List<Integer>> res = obj.verticalOrder(a);
        printTwoDArrayList(res);
        System.out.println("*********************");
//        
        TreeNode b = new TreeNode(3);
        b.left = new TreeNode(9);
        b.right = new TreeNode(20);
        b.left.left = new TreeNode(4);
        b.left.right = new TreeNode(5);
        b.right.left = new TreeNode(2);
        b.right.right = new TreeNode(7);
        List<List<Integer>> res2 = obj.verticalOrder(b);
        printTwoDArrayList(res2);
        System.out.println("*********************");
    }
    public List<List<Integer>> verticalOrder(TreeNode root) {
       
        //wrong result if using stack and using Integer map instead of TreeNode map
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if (root == null)
            return list;
        Map<Integer, List<Integer>> posToListMap = new HashMap<>();
        Map<TreeNode, Integer> valToPosMap = new HashMap<>();
        valToPosMap.put(root, 0);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int least = 0;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
//            System.out.println("curNode val: " + node.val);
            int curNodePos = valToPosMap.get(node);
//            List<Integer> sub = posToListMap.get(curNodePos + 1);
            if (!posToListMap.containsKey(curNodePos)) {
                posToListMap.put(curNodePos, new ArrayList<>());
            }
            posToListMap.get(curNodePos).add(node.val);
            if (node.left != null) {
                queue.add(node.left);
//                System.out.println("curNode position at left is: " + curNodePos);
                valToPosMap.put(node.left, curNodePos - 1);
            }
            if (node.right != null) {
                queue.add(node.right);
//                System.out.println("curNode position at right is: " + curNodePos);
                valToPosMap.put(node.right, curNodePos + 1);
            }
            
            least = Math.min(curNodePos, least);
//            System.out.println("valToPosMap.get(node): " + valToPosMap.get(node));
//            System.out.println("isStackEmpty ? " + stack.isEmpty());
//            System.out.println("least is: " + least);
        }
//        System.out.println("least " + least);
        while (posToListMap.containsKey(least)) {
//            System.out.println("get least: " + least);
            list.add(posToListMap.get(least));
            least++;
        }
        return list;
        
    }
    //print two dimensional array list, which can also be replaced by simply System.out.println(A)
    public static void printTwoDArrayList(List<List<Integer>> A)
    {
        for(int i = 0; i < A.size(); i++)
        {
            
            System.out.print(A.get(i) + " ");
            System.out.println("");
        }
        
    }
}
