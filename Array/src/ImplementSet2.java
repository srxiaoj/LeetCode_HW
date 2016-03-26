public class ImplementSet2 {
    public static void main(String[] args) {
        MySet2 set = new MySet2();
        MySet2 set2 = new MySet2();
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
//        set.remove(3);
        set.printSet();
        System.out.println("size is: " + set.size());
        System.out.println();
        System.out.println("size is: " + set2.size());
        set2.add(41);
        set2.add(81);
        set2.add(21);
        set2.printSet();


        MySet2 set3 = new MySet2();
        set3.add("value");
        set3.add("test");
        set3.add("map");
        set3.add("great");
        set3.add("this");
        String as = new String("good");
        set3.add(as);
        set3.printSet();
//        set3.remove("this");
//        set3.remove("good");
        set3.printSet();

        MySet2<String> set4 = new MySet2<>();
    }
}

class MySet2<T> {

    private T a[];
    int size = 0;
    public MySet2() {
        this.a = (T[]) new Object[0];
    }

    public MySet2(T[] element) {
        a = element;
        size = a.length;
    }

    /**
     * add element to set. A check is made to identify whether element is present or not.
     * <p>
     * If not the element can be inserted.
     *
     * @param element
     */

    public void add(T element) {
        if (!contains(element)) {
            if (size == a.length) {
                incrementArray();
            }
            a[size++] = element;
        }

    }


    /**
     * to check is element is present or not.
     *
     * @param elem
     * @return boolean
     */

    public boolean contains(T elem) {
        if (elem == null) {
            for (int i = 0; i < size; i++)
                if (a[i] == null)
                    return true;
        } else {
            for (int i = 0; i < size; i++)
                if (elem.equals(a[i]))
                    return true;
        }
        return false;


    }


    /**
     * return the size of set.
     *
     * @return int
     */

    public int size() {
        if (a != null) {
            return a.length;
        } else
            return 0;
    }


    public void clear() {
        a = null;
    }


    public String toString() {
        if (a == null || a.length == 0) {
            return "[EMPTY]";
        } else {
            String toStr = "[";
            for (int i = 0; i < a.length; i++) {
                toStr += a[i] + ",";
            }
            toStr += "]";
            return toStr;
        }

    }


    /**
     * to check whether set is empty or not
     *
     * @return
     */

    public boolean isEmpty() {
        if (a == null || a.length == 0)
            return true;
        else
            return false;
    }


    /**
     * this function is used to increment the size of an array
     */

    private void incrementArray() {
        T[] temparray = a;
        int tempsize = size + 5;
        a = (T[]) new Object[tempsize];
        System.arraycopy(temparray, 0, a, 0, size);
    }

    public void printSet() {
        for (int i = 0; i < size; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

}//MySet2 class ends