import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class DesignSnakeGame {
    public static void main(String[] args) {
        SnakeGame obj = new SnakeGame(3, 3, new int[][] {{2, 0}, {0, 0}, {0, 2}, {0, 1}, {2, 2}, {0, 1}});
        System.out.println(obj.move("D"));
        System.out.println(obj.move("D"));
        System.out.println(obj.move("R"));
        System.out.println(obj.move("U"));
        System.out.println(obj.move("U"));
        System.out.println(obj.move("L"));
        System.out.println(obj.move("D"));
        System.out.println(obj.move("R"));
        System.out.println(obj.move("R"));
        System.out.println(obj.move("U"));
        System.out.println(obj.move("L"));
        System.out.println(obj.move("L"));
        System.out.println(obj.move("D"));
        System.out.println(obj.move("R"));
        System.out.println(obj.move("U"));
    }

    public static class SnakeGame {

        int[][] food;
        int m;
        int n;
        int index;
        Deque<int[]> deque;
        Set<Integer> set;
        /** Initialize your data structure here.
         @param width - screen width
         @param height - screen height
         @param food - A list of food positions
         E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
        public SnakeGame(int width, int height, int[][] food) {
            m = height;
            n = width;
            this.food = food;
            index = 0;
            deque = new LinkedList<>();
            int[] origin = new int[] {0, 0};
            deque.add(origin);
            set = new HashSet<>();
            set.add(0 * n + 0);
        }

        /** Moves the snake.
         @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down
         @return The game's score after the move. Return -1 if game over.
         Game over when snake crosses the screen boundary or bites its body. */
        public int move(String direction) {
            int[] head = deque.peek();
            int[] last = deque.pollLast();
            int[] newHead = new int[] {head[0], head[1]};
            set.remove(last[0] * n + last[1]);
            if (direction.equals("U")) {
                newHead[0]--;
                if (newHead[0] < 0) return -1;
            } else if (direction.equals("D")) {
                newHead[0]++;
                if (newHead[0] >= m) return -1;
            } else if (direction.equals("L")) {
                newHead[1]--;
                if (newHead[1] < 0) return -1;
            } else {
                newHead[1]++;
                if (newHead[1] >= n) return -1;
            }

            if (set.contains(newHead[0] * n + newHead[1])) return -1;
            deque.offerFirst(newHead);
            set.add(newHead[0] * n + newHead[1]);
            if (index < food.length && newHead[0] == food[index][0] && newHead[1] == food[index][1]) {
                index++;
                deque.offerLast(last);
                set.add(last[0] * n + last[1]);
            }
//            System.out.println(set);
            return deque.size() - 1;
        }
    }
}
