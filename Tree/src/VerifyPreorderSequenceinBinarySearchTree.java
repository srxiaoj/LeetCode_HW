import java.util.Stack;

public class VerifyPreorderSequenceinBinarySearchTree {

    public static void main(String[] args) {
        TreeNode root = TreeNode.deserializeLevelorder("15,8,20,5,null,17,null,null,null,16,null");

//        System.out.println(verifyPreorder(new int[]{15, 8, 9, 5, 20, 17, 16}));
        System.out.println(verifyPreorder(new int[]{8, 5, 1, 7, 6, 20, 15}));
    }

    public static boolean verifyPreorder(int[] preorder) {
        int min = Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack();
        for (int p : preorder) {
            if (p < min) return false;

            // p > stack.peek() 说明后面要添加的数都在stack.peek()右边，所以应该都比stack.peek()大
            while (!stack.empty() && p > stack.peek()) {
                min = stack.pop();
            }
            stack.push(p);
        }
        return true;
    }

    //print array
    public static void printArray(int[] A) {
        for (int i = 0; i < A.length; i++) {
            if (i != A.length - 1)
                System.out.print(A[i] + ", ");
            else
                System.out.print(A[i]);
        }
        System.out.println("");
    }
}
