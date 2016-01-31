import java.util.Arrays;

public class UniqueBinarySearchTrees {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(numTrees(2));
    }
    public static int numTrees(int n) {
        if (n == 0) return 1;
        if (n == 1) return 1;
        int[] count = new int[n + 1];
        Arrays.fill(count, 0);
        count[0] = 1;
        count[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                count[i] += count[j] * count[i - 1 - j];
            }
        }
        return count[n];
        /*int count = 0;
        if (n == 0 || n == 1) return 1;
        for (int i = 0; i < n; i++) {
            count += numTrees(i) * numTrees(n - 1 - i);
        }
        return count;*/
    }
}
