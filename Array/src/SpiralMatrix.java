import java.util.ArrayList;
import java.util.List;

/**
 * Created by thanksgiving on 3/28/16.
 */
public class SpiralMatrix {
    public static void main(String[] args) {
        char[][] matrix = {
                {'U','R','Y'},
                {'E','X','Y'},
                {'B','J','B'}
        };
        SpiralMatrix obj = new SpiralMatrix();
        System.out.println(obj.spiralOrder(matrix));

        int[][] m = {{1}};
        System.out.println(obj.spiralOrder(m));
    }

    public List<Character> spiralOrder(char[][] matrix) {
        List<Character> res = new ArrayList<Character>();
        if (matrix.length == 0) {
            return res;
        }
        int rowBegin = 0;
        int rowEnd = matrix.length - 1;
        int colBegin = 0;
        int colEnd = matrix[0].length - 1;
        while (rowBegin <= rowEnd && colBegin <= colEnd) {
            // Traverse Right
            for (int j = colBegin; j <= colEnd; j++) {
                res.add(matrix[rowBegin][j]);
            }
            rowBegin++;
            // Traverse Down
            for (int j = rowBegin; j <= rowEnd; j++) {
                res.add(matrix[j][colEnd]);
            }
            colEnd--;
            if (rowBegin <= rowEnd) {
                // Traverse Left
                for (int j = colEnd; j >= colBegin; j--) {
                    res.add(matrix[rowEnd][j]);
                }
            }
            rowEnd--;
            if (colBegin <= colEnd) {
                // Traver Up
                for (int j = rowEnd; j >= rowBegin; j--) {
                    res.add(matrix[j][colBegin]);
                }
            }
            colBegin++;
        }
        return res;
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0) return res;
        int rowS = 0, rowE = matrix.length - 1;
        int colS = 0, colE = matrix[0].length - 1;
        while (rowS <= rowE && colS <= colE) {
            for (int i = colS; i <= colE; i++) {
                res.add(matrix[rowS][i]);
            }
            rowS++;
            for (int i = rowS; i <= rowE; i++) {
                res.add(matrix[i][colE]);
            }
            colE--;
            if (rowS <= rowE) {
                for (int i = colE; i >= colS; i--) {
                    res.add(matrix[rowE][i]);
                }
            }
            rowE--;
            if (colS <= colE) {
                for (int i = rowE; i >= rowS; i--) {
                    res.add(matrix[i][colS]);
                }
            }
            colS++;
        }
        return res;
    }
}
