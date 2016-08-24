import java.util.*;

/**
 * Created by thanksgiving on 8/23/16.
 */
public class InsertDeleteGetRandom {
    public static void main(String[] args) {
        RandomizedSet obj = new RandomizedSet();
        boolean param_1 = obj.insert(-1);
        boolean param_2 = obj.remove(-2);
        int param_3 = obj.getRandom();
        System.out.println(param_3);
        obj.insert(-2);
        System.out.println(obj.getRandom());
        obj.remove(-2);
        System.out.println(obj.getRandom());
    }
}

class RandomizedSet {
    Set<Integer> set;
    List<Integer> list;
    /** Initialize your data structure here. */
    public RandomizedSet() {
        set = new HashSet<>();
        list = new ArrayList<>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (set.contains(val)) {
            return false;
        }
        set.add(val);
        list.add(val);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (set.contains(val)) {
            set.remove(val);
            list.remove((Integer) val);
            return true;
        }
        return false;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        int size = list.size();
        Random r = new Random();
        int next = r.nextInt(size);
        return list.get(next);
    }
}
