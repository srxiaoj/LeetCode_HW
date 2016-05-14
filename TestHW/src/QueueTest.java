import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by thanksgiving on 5/14/16.
 */
public class QueueTest {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();
        queue.offer("ABC");
        queue.offer("DGF");
        queue.offer("ADF");
        System.out.println(queue.peek());
    }
}
