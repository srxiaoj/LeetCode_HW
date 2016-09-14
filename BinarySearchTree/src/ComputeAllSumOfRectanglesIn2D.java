import java.util.*;

/**
 * Created by thanksgiving on 9/14/16.
 */
public class ComputeAllSumOfRectanglesIn2D {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 0, 1},
                {0, -2, 3},
        };
        System.out.println(getAllSums(matrix));
    }

    public static List<Integer> getAllSums(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int m = matrix.length, n = matrix[0].length;
        int[] rowSum;
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < m; i++) {
            rowSum = new int[n];
            for (int j = i; j >= 0; j--) {
                int sum = 0;
                for (int k = 0; k < n; k++) {
                    rowSum[k] += matrix[j][k];
                    set.add(rowSum[k]);
                    sum += rowSum[k];
                    set.add(sum);
                }
            }
        }
        for (int i : set) {
            res.add(i);
        }
        Collections.sort(res);
        return res;
    }
}
