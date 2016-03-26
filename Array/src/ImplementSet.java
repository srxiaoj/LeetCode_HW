import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by thanksgiving on 2/21/16.
 */
public class ImplementSet {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        MySet set = new MySet();
        MySet set2 = new MySet();
        set.add(5);
        set.add(3);
        set.add(1);
        System.out.println("size is: " + set.size());
        set.printSet();
        set2.add(51);
        set2.add(31);
        set2.add(11);
        set2.add(61);
        set.add(6);
        set.add(4);
        set.add(8);
        set.add(2);
        set.printSet();
        set.remove(3);
        System.out.println("size is: " + set.size());
        Iterator<Integer> it = set.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println();
        System.out.println("size is: " + set2.size());
        set2.add(41);
        set2.add(81);
        set2.add(21);
        set2.printSet();


        MySet set3 = new MySet();
        set3.add(null);
        System.out.println(set3.isEmpty());
        set3.add("value");
        set3.add("test");
        set3.add("map");
        set3.add("great");
        set3.add("this");
        String as = new String("good");
        set3.add(as);
        set3.printSet();
        set3.remove("this");
        set3.remove("good");
        set3.printSet();
    }
}

class MySet<T> {
    private int size;
    private T[] a;
    private int pos; // cannot be static
    private int expandSize;

    //    public MySet(Class<T> c) {
    public MySet() {
        expandSize = 3;
        size = 3;
        a = (T[]) new Object[size];
//        a = (T[]) Array.newInstance(c, size);
        pos = 0;
    }

    public boolean add(T element) {
        if (element == null) {
            System.out.println("Cannot add null");
            return false;
        }
        if (!contains(element)) {
            a[pos] = element;
            pos++;
            if (pos < size) {
                size += expandSize;
                T[] newArray = (T[]) new Object[size];
                // copy from a to newArray starting from 0 with copy length pos
                System.arraycopy(a, 0, newArray, 0, pos);
                a = newArray;
            }
            return true;
        } else {
            return false;
        }
    }

    public boolean remove(T element) {
        if (contains(element)) {
            for (int i = 0; i < a.length; i++) {
                if (a[i] != null && a[i].equals(element)) {
                    for (int k = i; k < pos; k++) {
                        a[k] = a[k + 1];
                    }
                    break;
                }
            }
            // take care the last element and reduce index by one
            a[pos] = null;
            pos--;
            return true;
        } else {
            return false;
        }
    }

    public boolean contains(T element) {
        if (element == null) {
            for (int i = 0; i < pos; i++) {
                if (a[i] == null)
                    return true;
            }
        } else {
            for (int i = 0; i < pos; i++) {
                if (a[i] != null && element.equals(a[i])) {
                    return true;
                }
            }
        }
        return false;
    }

    public int size() {
        return pos;
    }

    public void printSet() {
        for (int i = 0; i < pos; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public void clear() {
        size = 3;
        for (int i = 0; i < pos; i++) {
            a[i] = null;
        }
        pos = 0;
    }

    public boolean isEmpty() {
        return (a == null || pos == 0);
    }

    public Iterator<T> iterator() {
        List<T> list = new ArrayList<>();
        for (int i = 0; i < pos; i++) {
            list.add(a[i]);
        }
        return list.iterator();
    }
}