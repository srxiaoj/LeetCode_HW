import java.util.*;

/**
 * Created by thanksgiving on 8/31/16.
 */
public class InsertDeleteGetRandomWithDup {
    public static void main(String[] args) {
        RandomizedCollection obj = new RandomizedCollection();
        System.out.println(obj.insert(1));
        System.out.println(obj.insert(1));
        System.out.println(obj.insert(2));
        System.out.println(obj.getRandom());
        System.out.println(obj.remove(1));
        System.out.println(obj.getRandom());
    }

    public static class RandomizedCollection {

        Map<Integer, Integer> map;
        List<Integer> list;
        Random r;
        /** Initialize your data structure here. */
        public RandomizedCollection() {
            map = new HashMap<>();
            list = new ArrayList<>();
            r = new Random();
        }

        /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
        public boolean insert(int val) {
            int count;
            if (!map.containsKey(val)) {
                count = 1;
                list.add(val);
                map.put(val, count);
                return true;
            } else {
                count = map.get(val);
                map.put(val, count + 1);
                list.add(val);
                return false;
            }
        }

        /** Removes a value from the collection. Returns true if the collection contained the specified element. */
        public boolean remove(int val) {
            if (!map.containsKey(val)) {
                return false;
            }
            int count = map.get(val);
            count--;
            for (int j = 0; j < list.size(); j++) {
                if (list.get(j) == val) {
                    list.remove(j);
                }
            }
            if (count == 0) {
                map.remove(val);
            }
            return true;
        }

        /** Get a random element from the collection. */
        public int getRandom() {
            int next = r.nextInt(list.size());
            return list.get(next);
        }
    }
}
