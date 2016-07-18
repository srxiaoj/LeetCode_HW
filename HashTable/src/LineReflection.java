import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by thanksgiving on 7/17/16.
 */
public class LineReflection {
    public static void main(String[] args) {
        System.out.println(isReflected(new int[][]{{1, 1}, {-1, 1}}));
        System.out.println(isReflected(new int[][]{{0, 0}, {1, 0}}));
    }

    public static boolean isReflected(int[][] points) {
        HashSet<Integer> pointSet = new HashSet<>();
        int sum;
        int maxX, minX;

        minX = Integer.MAX_VALUE;
        maxX = Integer.MIN_VALUE;
        for (int[] point : points) {
            maxX = Math.max(maxX, point[0]);
            minX = Math.min(minX, point[0]);
            pointSet.add(Arrays.hashCode(point));
        }

        sum = maxX + minX;
        for (int[] point : points) {
            if (!pointSet.contains(Arrays.hashCode(new int[]{sum - point[0], point[1]}))) {
                return false;
            }
        }
        return true;
    }
}
