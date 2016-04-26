/**
 * Created by thanksgiving on 1/13/16.
 */
public class WallsandGates {
    public static final int INF = Integer.MAX_VALUE;
    public static void main(String[] args) {
        WallsandGates obj = new WallsandGates();
        int[][] rooms = {
                {INF, -1,   0,   INF},
                {INF, INF, INF, -1},
                {INF, -1,  INF, -1},
                {0,   -1,  INF, INF}
        };
        obj.wallsAndGates(rooms);
        printArray(rooms);
    }

    /**
     * 从rooms[i][j] == 0的点开始bfs， 只更新rooms[i][j] > distance的点，每次扩张distance + 1
     * @param rooms
     */
    public void wallsAndGates(int[][] rooms) {
        int row = rooms.length;
        if (row == 0) return;
        int col = rooms[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (rooms[i][j] == 0)
                    bfs(rooms, i, j, 0);
            }
        }
    }

    private void bfs(int[][] rooms, int i, int j, int distance) {
        // core step, only update when rooms[i][j] > distance
        if (i < 0 || i >= rooms.length || j < 0 || j >= rooms[0].length || rooms[i][j] < distance) return;
        rooms[i][j] = distance;
        bfs(rooms, i - 1, j, distance + 1);
        bfs(rooms, i + 1, j, distance + 1);
        bfs(rooms, i, j - 1, distance + 1);
        bfs(rooms, i, j + 1, distance + 1);
    }

    /**
     * print 2D array.
     * @param A array
     */
    private static void printArray(int[][] A)
    {
        for(int i = 0; i < A.length; i++)
        {
            for (int j = 0; j < A[i].length; j++) {
                if(j != A[i].length-1) {
                    System.out.print(A[i][j] + ", ");
                } else
                    System.out.print(A[i][j]);

            }
            System.out.println(" ");
        }
        System.out.println(" ");
    }
}
