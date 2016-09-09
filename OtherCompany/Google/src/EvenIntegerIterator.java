import java.util.Iterator;

/**
 * Created by thanksgiving on 7/5/16.
 */
public class EvenIntegerIterator implements Iterator<Integer> {
    public static void main(String[] args) {
        EvenIntegerIterator it = new EvenIntegerIterator();
        System.out.println(it.next());
    }

    private int cur = 2;
    public EvenIntegerIterator() {
        cur = 2;
    }

    public Integer next() {
        if (hasNext()) {
            return cur;
        }
        return -1;
    }

    public boolean hasNext() {
        if ((long) cur + 2 <= (long) Integer.MAX_VALUE) {
            cur = cur + 2;
            return true;
        }
        return false;
    }
}
