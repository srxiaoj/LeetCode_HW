
public class UniqueBinarySearchTrees {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(numTrees(2));
    }
    public static int numTrees(int n) {
        int count = 0;
        if (n == 0 || n == 1) return 1;
        for (int i = 0; i < n; i++) {
            count += numTrees(i) * numTrees(n - 1 - i);
        }
        return count;
    }
}
