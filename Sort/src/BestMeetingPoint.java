import java.util.ArrayList;
import java.util.List;

public class BestMeetingPoint {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
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
        List<Loc> list = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    list.add(new Loc(i, j));
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                int distance = 0;
                for (Loc d : list) {
                    distance += Math.abs(d.x - i) + Math.abs(d.y - j);
                }
                min = Math.min(min, distance);
            }
        }
        return min;
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