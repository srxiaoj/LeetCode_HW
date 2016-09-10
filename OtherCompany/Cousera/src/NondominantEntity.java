import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by thanksgiving on 9/10/16.
 */
public class NondominantEntity {
   /* public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        final String fileName = System.getenv("OUTPUT_PATH");
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
        int res;

        int size = 0;
        size = Integer.parseInt(in.nextLine().trim());
        int[][] pairs = new int[size][2];
        String[] _one_line;
        for (int _i = 0; _i < size; _i++) {
            try {
                _one_line = in.nextLine().split(" ");
            } catch (Exception e) {
                _one_line = null;
            }
            pairs[_i][0] = Integer.parseInt(_one_line[0]);
            pairs[_i][1] = Integer.parseInt(_one_line[1]);
        }

        res = getNondominate(pairs);
        bw.write(String.valueOf(res));
        bw.newLine();

        bw.close();
    }*/
    public static void main(String[] args) {
        int[][] pairs = {
                {3,2},
                {3,4},
                {6,9},
                {7,8},
                {8,7},
                {8,8}
        };
        System.out.println(getNondominate(pairs));
    }

    public static int getNondominate(int[][] pairs) {
        if (pairs == null || pairs.length == 0) return 0;
        Arrays.sort(pairs, new MyComparator());
        printArray(pairs);

        List<Integer> res = new ArrayList<>();
        res.add(pairs[0][1]);
        for (int i = 1; i < pairs.length; i++) {
            if (pairs[i][1] >= res.get(res.size() - 1)) {
                res.add(pairs[i][1]);
            }
        }
        return res.size();
    }

    static class MyComparator implements Comparator<int[]> {
        public int compare(int[] a, int[] b) {
            if (b[0] == a[0]) return a[1] - b[1];
            return b[0] - a[0];
        }
    }

    /**
     * print 2D array.
     */
    public static void printArray(int[][] A) {
        for (int i = 0; i < A.length; i++) {
            System.out.print("[");
            for (int j = 0; j < A[i].length; j++) {
                if (j != A[i].length - 1) {
                    System.out.print(A[i][j] + ", ");
                } else
                    System.out.print(A[i][j]);

            }
            System.out.println("]");
        }
        System.out.println("");
    }
}
