import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class GameofLife {

    public static void main(String[] args) {
        //block
        int[][] block = new int[4][4];
//        initialize(block);
        block[1][1] = 1;
        block[1][2] = 1;
        block[2][1] = 1;
        block[2][2] = 1;
        //beehive
        int[][] beehive = new int[5][6];
//        initialize(beehive);
        beehive[1][2] = 1;
        beehive[1][3] = 1;
        beehive[2][1] = 1;
        beehive[2][4] = 1;
        beehive[3][2] = 1;
        beehive[3][3] = 1;
        //blinker
        int[][] blinker = new int[5][5];
//        initialize(blinker);
        blinker[2][1] = 1;
        blinker[2][2] = 1;
        blinker[2][3] = 1;

        Utils.printArray(beehive);
        System.out.println("Start game of life");
        gameOfLife(beehive);
        Utils.printArray(beehive);

    }

    /**
     * https://discuss.leetcode.com/topic/29054/easiest-java-solution-with-explanation/2
     */
    public static void gameOfLife(int[][] board) {
        if (board == null || board.length == 0) return;
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int live = countLive(board, i, j);
                if (board[i][j] == 1 && (live == 2 || live == 3)) {
                    board[i][j] = 3;
                }
                if (board[i][j] == 0 && live == 3) {
                    board[i][j] = 2;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = board[i][j] >> 1;
            }
        }
    }

    private static int countLive(int[][] board, int x, int y) {
        int count = 0;
        int m = board.length, n = board[0].length;
        for (int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + 1; j++) {
                if (i >= 0 && i < m && j >= 0 && j < n) {
                    count += (board[i][j] & 1);
                }
            }
        }
        count -= (board[x][y] & 1);
        return count;
    }


    // Infinite board follow up

    /**
     * Use a set to store the coordinate of all current live cells
     * use a count map to store the number of live cells surrounded
     */
    private static Set<Coord> updateBoardStatus(Set<Coord> live) {
        Map<Coord, Integer> countMap = new HashMap<>();
        for (Coord cell : live) {
            for (int i = cell.i - 1; i <= cell.i + 1; i++) {
                for (int j = cell.j - 1; j <= cell.j + 1; j++) {
                    if (i == cell.i && j == cell.j) continue;
                    Coord c = new Coord(i, j);
                    if (countMap.containsKey(c)) {
                        countMap.put(c, countMap.get(c) + 1);
                    } else {
                        countMap.put(c, 1);
                    }
                }
            }
        }
        Set<Coord> newLive = new HashSet<>();
        for (Map.Entry<Coord, Integer> cell : countMap.entrySet()) {
            if (cell.getValue() == 3 || cell.getValue() == 2 && live.contains(cell.getKey())) {
                newLive.add(cell.getKey());
            }
        }
        return newLive;
    }

    public static void gameOfLifeInfiniteBoard(int[][] board) {
        Set<Coord> live = new HashSet<>();
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1) {
                    live.add(new Coord(i, j));
                }
            }
        }

        live = updateBoardStatus(live);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = live.contains(new Coord(i, j)) ? 1 : 0;
            }
        }
    }

    private static class Coord {
        int i;
        int j;

        private Coord(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public boolean equals(Object o) {
            return o instanceof Coord && ((Coord) o).i == i && ((Coord) o).j == j;
        }

        public int hashCode() {
            int hashCode = 1;
            hashCode = 31 * hashCode + i;
            hashCode = 31 * hashCode + j;
            return hashCode;
        }
    }

    /**
     * initialize the board with 0.
     */
    private static void initialize(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = 0;
            }
        }
    }
}
