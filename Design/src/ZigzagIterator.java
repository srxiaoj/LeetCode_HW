import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Created by thanksgiving on 1/10/16.
 */
public class ZigzagIterator {
    public static void main(String[] args) {
        //Your ZigzagIterator object will be instantiated and called as such:
        List<Integer> v1 = Arrays.asList(1, 2);
        List<Integer> v2 = Arrays.asList(3, 4, 5, 6);
        ZigzagIter i = new ZigzagIter(v1, v2);
        while (i.hasNext()) {
            int tmp = i.next();
            System.out.print(tmp + " ");
        }
    }

}
class ZigzagIter {
    private List<Integer> list = new ArrayList<>();
    private Iterator<Integer> it;
    public ZigzagIter(List<Integer> v1, List<Integer> v2) {
        Iterator<Integer> it1 = v1.iterator();
        Iterator<Integer> it2 = v2.iterator();
        while (it1.hasNext() && it2.hasNext()) {
            int i1 = it1.next();
            int i2 = it2.next();
            list.add(i1);
            list.add(i2);
        }
        if (!it1.hasNext()) {
            while (it2.hasNext()) {
                list.add(it2.next());
            }
        } else {
            while (it1.hasNext()) {
                list.add(it1.next());
            }
        }
        it = list.iterator();
    }

    public int next() {
        int i = -1;
        if (it.hasNext()) {
            i = it.next();
        }
        return i;
    }

    public boolean hasNext() {
        return it.hasNext();
    }
}