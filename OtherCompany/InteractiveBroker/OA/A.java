/**
 * Created by thanksgiving on 9/8/16.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class A {
    private final Character m_value = 'a';

    public String toString() {return "" + m_value;}

    public static void main(String[] args) {
       /* try {
            Field f = A.class.getDeclaredField("m_value");
            f.setAccessible(true);
            A a = new A();
            f.set(a, (char) 'b');
            System.out.println(a);
        } catch (Exception e) {
            e.printStackTrace();
        }*/


       /* Map<Integer, String> map = new HashMap<>();
        map.put(1, "apple");
        map.put(2, null);
        map.put(new Integer(3), "peach");
        map.put(3, "orange");
        map.put(4, "peach");

        for (String v : map.values()) {
            if ("orange".equals(v)) {
                map.put(5, "banana");
            }
        }*/

        final List<Integer> list = new ArrayList<>();
        Collections.addAll(list, 1, 5, 2, 3, 7, 3, 8, 9);
        final Integer pos = Integer.valueOf(3);
        list.remove(pos);
        System.out.println(list);
    }
}
