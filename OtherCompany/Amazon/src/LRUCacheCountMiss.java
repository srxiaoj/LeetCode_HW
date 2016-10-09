import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 2016/10/8.
 */
public class LRUCacheCountMiss {
    public static void main(String[] args) {
        System.out.println(getMissCount(new int[] {1, 2, 3, 4, 5, 1, 2}, 3));
        System.out.println(getMissCount(new int[] {1, 2, 3, 1, 2}, 3));
    }

    public static int getMissCount(int[] array, int size) {
        if (array == null)  return 0;
        List<Integer> cache = new LinkedList<Integer>();
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (cache.contains(array[i])) {
                cache.remove(new Integer(array[i]));
            } else {
                count++;
                if (size == cache.size())
                    cache.remove(0);
            }
            cache.add(array[i]);
        }
        return count;
    }
}
