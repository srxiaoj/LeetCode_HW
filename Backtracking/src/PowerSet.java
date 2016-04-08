import java.util.HashSet;
import java.util.Set;

/**
 * Created by thanksgiving on 4/8/16.
 */
public class PowerSet {
    public static void main(String[] args) {
        PowerSet obj = new PowerSet();
        Set<Integer> set = new HashSet<>();
        set.add(5);
        set.add(11);
        set.add(2);
        Set<Set<Integer>> res = obj.powerSet(set);
        System.out.println(res);
    }

    /**
     * start:                 [2,5,11]
     * separate:              2, [5,11]
     * get subPowerSet:       2, [[5],[11],[5,11]]
     * add 2 to subPowerSet:  [[2,5],[2,11],[2,5,11]]
     * combine set of first element, set from subPowerset and set after add 2 to subPowerSet
     * @param set
     * @return
     */
    public Set<Set<Integer>> powerSet(Set<Integer> set) {
        Set<Set<Integer>> res = new HashSet<>();
        if (set == null) {
            return res;
        }

        boolean first = true;
        int firstElement = 0;
        Set<Integer> setWithoutFirst = new HashSet<>();
        for (int a : set) {
            if (first) {
                firstElement = a;
                first = false;
            } else {
                setWithoutFirst.add(a);
            }
        }
        Set<Integer> firstSet = new HashSet<>();
        firstSet.add(firstElement);
        res.add(firstSet);
        if (setWithoutFirst.isEmpty()) {
            return res;
        }

        Set<Set<Integer>> subPowerSet = powerSet(setWithoutFirst);
        for (Set<Integer> s : subPowerSet) {
            // add the copy of this set first, then add the first element into this set, then add the new set
            res.add(new HashSet<>(s));
            s.add(firstElement);
            res.add(s);
        }
        return res;
    }
}
