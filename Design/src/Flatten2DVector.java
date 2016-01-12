import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Created by thanksgiving on 1/8/16.
 */
public class Flatten2DVector {
    public static void main(String[] args) {
        Flatten2DVector obj = new Flatten2DVector();
        List<List<Integer>> vec2d = new ArrayList<>();
        List<Integer> a = Arrays.asList(1, 2);
        List<Integer> b = Arrays.asList(3);
        List<Integer> c = Arrays.asList(4, 5, 6);
        vec2d.add(a);
        vec2d.add(b);
        vec2d.add(c);

        Vector2D i = new Vector2D(vec2d);
        while (i.hasNext()) {
            int tmp = i.next();
            System.out.print(tmp + " ");
        }
    }
}

class Vector2D {
    private List<Integer> list = new ArrayList<>();
    private Iterator<Integer> it;

    public Vector2D(List<List<Integer>> vec2d) {
        if (vec2d == null || vec2d.isEmpty()) return;
        for (int i = 0; i < vec2d.size(); i++) {
            for (int j = 0; j < vec2d.get(i).size(); j++) {
                list.add(vec2d.get(i).get(j));
            }
        }
        it = list.iterator();
    }

    public int next() {
        int res = -1;
        if (it.hasNext()) {
            res = it.next();
        }
        return res;
    }

    public boolean hasNext() {
        return it != null && it.hasNext();
    }//it cannot be null
}
