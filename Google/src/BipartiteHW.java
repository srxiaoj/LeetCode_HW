import java.util.HashSet;
import java.util.Set;

/**
 * Created by thanksgiving on 7/17/16.
 */
public class BipartiteHW {
    public static void main(String[] args) {
        /**
         *  0--1
         *   \/
         *   /\
         *  2--3
         *  true
         */
        int edge1[][] = {
                {0, 1, 0, 1},
                {1, 0, 1, 0},
                {0, 1, 0, 1},
                {1, 0, 1, 0}
        };
        System.out.println(isBipartite(edge1));

        /**
         *  0--1
         *
         *  2--3
         *  true
         */
        int edge2[][] = {
                {0, 1, 0, 0},
                {1, 0, 0, 0},
                {0, 0, 0, 1},
                {0, 0, 1, 0}
        };
        System.out.println(isBipartite(edge2));

        /**
         *  0--1
         *  |
         *  2--3
         *  true
         */
        int edge3[][] = {
                {0, 1, 1, 0},
                {1, 0, 0, 0},
                {1, 0, 0, 1},
                {0, 0, 1, 0}
        };
        System.out.println(isBipartite(edge3));

        /**
         *  0--1
         *  | \
         *  2--3
         *  false
         */
        int edge4[][] = {
                {0, 1, 1, 1},
                {1, 0, 0, 0},
                {1, 0, 0, 1},
                {1, 0, 1, 0}
        };
        System.out.println(isBipartite(edge4));
    }

    public static boolean isBipartite(int[][] edge) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        int n = edge.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (edge[i][j] == 1) {
                    if (set1.contains(i) && set1.contains(j) || set2.contains(i) && set2.contains(j)) {
                        return false;
                    } else if (set1.contains(i)) {
                        set2.add(j);
                    } else if (set2.contains(i)) {
                        set1.add(j);
                    } else {
                        set1.add(i);
                        set2.add(j);
                    }
                }
            }
        }
//        System.out.println(set1);
//        System.out.println(set2);
        return true;
    }
}
