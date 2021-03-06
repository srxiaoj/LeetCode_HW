import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by thanksgiving on 4/26/16.
 */
public class LRUCache {
    public static void main(String[] args) {
        LRUCache obj = new LRUCache(5);
        obj.set(2, 1);
        obj.get(2);
        obj.set(3, 2);
        obj.get(2);
        obj.get(3);
        obj.set(1, 0);
        obj.set(5, 0);
        obj.set(7, 0);
        obj.get(1);
        obj.set(10, 0);
        System.out.println(obj);
    }


    HashMap<Integer, Integer> cache;
    ArrayList<Integer> list;
    int count;

    /**
     * 添加以及删除时都要更新list中位置，新添加时添加到尾部，移除时移除 0 位置
     * list.remove 需要 remove new Integer(key) object
     * @param capacity
     */
    public LRUCache(int capacity) {
        cache = new HashMap<Integer, Integer>(capacity);
        list = new ArrayList<Integer>(capacity);
        count = capacity;
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            // new Integer(key) is nessary
            list.remove(new Integer(key));
            list.add(key);
            return cache.get(key);
        } else
            return -1;
    }

    public void set(int key, int value) {
        if (cache.containsKey(key)) {
            cache.put(key, value);
            // new Integer(key) is necessary
            list.remove(new Integer(key));
            list.add(key);
        } else {
            if (cache.size() < count) {
                cache.put(key, value);
                list.add(key);
            } else {
                int leastkey = list.remove(0);
                list.add(key);
                cache.remove(leastkey);
                cache.put(key, value);
            }
        }
    }

    public String toString() {
        return cache.toString();
    }
}
