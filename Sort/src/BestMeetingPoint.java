import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BestMeetingPoint {

    public static void main(String[] args) {
        int[] oneD = {1, 0, 0, 1, 0};
//        System.out.println(minTotalDistance1D(oneD));
        
        int[][] twoD = {{1, 0, 0, 0, 1},
                        {0, 0, 0, 0, 0},
                        {0, 0, 1, 0, 0}};
        System.out.println(minTotalDistance(twoD));
    }
    
    public static int minTotalDistance1D(int[] grid) {
        List<Integer> position = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            if (grid[i] == 1) {
                position.add(i);
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < grid.length; i++) {
            int distance = 0;
            for (int d : position) {
                distance += Math.abs(d - i);
            }
            min = Math.min(min, distance);
        }
        return min;
    }
    public static int minTotalDistance(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int m = grid.length, n = grid[0].length;

        List<Integer> x = new ArrayList<>();
        List<Integer> y = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    x.add(i);
                    y.add(j);
                }
            }
        }

        Collections.sort(x);
        Collections.sort(y);
        int midX = x.get(x.size() / 2);
        int midY = y.get(y.size() / 2);

        int res = 0;
        for (int i : x) {
            res += Math.abs(i - midX);
        }

        for (int i : y) {
            res += Math.abs(i - midY);
        }
        return res;
    }
}

class Loc {
    int x;
    int y;
    Loc (int a, int b) {
        x = a;
        y = b;
    }
}