import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class PassByValue {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        //modify integer
        System.out.println("***********");
        int test = 1;
        modifyValue(test);
        System.out.println(test);
        
        //modify array
        System.out.println("***********");
        int[] testArray = {1, 2, 3, 5};
        swapArray(testArray, 0, 3);
        System.out.println(testArray[0]);
        //modify tree
        
        //modify linked list
        System.out.println("***********");
        List<Integer> aLinkedList = new LinkedList<>(Arrays.asList(11, 15, 3, 6));
        System.out.println(aLinkedList);
        
        //modify array list
        System.out.println("***********");
        List<Integer> aList = new ArrayList<>(Arrays.asList(8, 5, 3, 1));
//        swapArrayList(aList, 0, 3);
        aList.add(11);
        Collections.swap(aList, 0, 3);
        System.out.println(aList);
        
        List<Integer> aImmutableList = Arrays.asList(7, 8, 9, 10); // cannot remove/add element
        Collections.swap(aImmutableList, 0, 3);
//        aImmutableList.add(11);
        System.out.println(aImmutableList);
        
        // modify stringBuilder
        
    }
    private static final String SPLITTER = ",";
    private static final String NN = "null";
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildString(root, sb);
        sb.deleteCharAt(sb.length() - 1); // delete the last splitter
        return sb.toString();
    }
    /**
     * modify stringBuilder
     * @param node
     * @param sb
     */
    private void buildString(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append(NN).append(SPLITTER);
        } else {
            sb.append(node.val).append(SPLITTER);
            buildString(node.left, sb);
            buildString(node.right,sb);
        }
    }
    public static void swapArrayList(List<Integer> aList, int i, int j) {
        int tmp = aList.get(i);
        aList.set(i, aList.get(j));
        aList.set(j, tmp);
    }
    /**
     * array is pass by reference?
     * @param array
     * @param i
     * @param j
     */
    public static void swapArray(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
    /**
     * pass by value
     * @param x
     */
    public static void modifyValue(int x) {
        x = x * 2;
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode (int x) { val = x; }
}