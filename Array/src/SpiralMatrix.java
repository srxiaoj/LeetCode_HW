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
}
