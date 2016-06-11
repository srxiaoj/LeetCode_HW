import java.util.List;
import java.util.Map;


public class FrequentlyUsedMethods {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    //print one dimensional array list, which can also be replaced by simply System.out.println(A);
    public static void printArrayList(List<Integer> A) {
        //use System.out.println(A) directly or:
        for (int i = 0; i < A.size(); i++) {
            System.out.print(A.get(i) + " ");
        }
    }

    //print two dimensional array list, which can also be replaced by simply System.out.println(A)
    public static void printTwoDArrayList(List<List<Integer>> A) {
        for (int i = 0; i < A.size(); i++) {

            System.out.print(A.get(i) + " ");
            System.out.println("");
        }

    }

    //print array
    public static void printArray(int[] A) {
        System.out.print("[");
        for (int i = 0; i < A.length; i++) {
            if (i != A.length - 1)
                System.out.print(A[i] + ", ");
            else
                System.out.print(A[i]);
        }
        System.out.println("]");
    }

    /**
     * print 2D array.
     * @param A array
     */
    public static void printArray(int[][] A) {
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                if (j != A[i].length - 1) {
                    System.out.print(A[i][j] + ", ");
                } else
                    System.out.print(A[i][j]);

            }
            System.out.println("");
        }
        System.out.println("");
    }

    //print out hashtable
    private static void printHash(Map<String, Integer> map) {
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String key = entry.getKey();
            int value = entry.getValue();
            System.out.println(key + ": " + value);
        }

    }

    //get level of list
    private static int getLevelOfList(ListNode head) {
        ListNode res = head;
        int level = 0;
        while (res != null) {
            //System.out.println(res.val);
            res = res.next;
            level++;
        }
        System.out.println("level is: " + level);
        return level;
    }

    //print out list
    private static void printList(ListNode res) {
        while (res != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }
        System.out.println("");
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}