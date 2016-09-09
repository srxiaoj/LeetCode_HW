import java.util.*;

/**
 * Created by thanksgiving on 7/13/16.
 */
public class LargestPossibleMatrix {
    public static void main(String[] args) {
        List<Dimension> list = new ArrayList(Arrays.asList(new Dimension(4, 2), new Dimension(3, 2), new Dimension(2, 5), new Dimension(6, 3), new Dimension(2, 6)));
        System.out.println(getLargestMatrix(list));
    }

    public static int getLargestMatrix(List<Dimension> list) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (Dimension m : list) {
            List<Integer> val;
            if (!map.containsKey(m.row)) {
                val = new ArrayList<>();

            } else {
                val = map.get(m.row);
            }
            val.add(m.col);
            map.put(m.row, val);
        }

        int max = 0;
        for (Dimension m : list) {
            if (map.containsKey(m.col)) {
                List<Integer> match = map.get(m.col);
                Collections.sort(match);
                max = Math.max(max, m.row * match.get(match.size() - 1));
            }
            max = Math.max(max, m.row * m.col);
        }
        return max;
    }

    private static class Dimension {
        int row;
        int col;
        public Dimension(int x, int y) {
            row = x;
            col = y;
        }
        public String toString() {
            return row + " x " + col;
        }
    }
}
