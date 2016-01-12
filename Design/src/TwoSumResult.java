import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by thanksgiving on 1/3/16.
 */
public class TwoSumResult {
    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        twoSum.add(0);
        twoSum.add(-1);
        twoSum.add(1);
        System.out.println(twoSum.find(0));
    }
}

class TwoSum {
    private HashMap<Integer, Integer> map = new HashMap<>();
    private List<Integer> list = new ArrayList<>();

    // Add the number to an internal data structure.
    public void add(int number) {
        if (!map.containsKey(number)) {
            map.put(number, 1);
            list.add(number);
        } else {
            map.put(number, map.get(number) + 1);
        }
    }

    // Find if there exists any pair of numbers which sum is equal to the value.
    public boolean find(int value) {
        for (int i = 0; i < list.size(); i++) {
            int target = value - list.get(i);
            if (map.containsKey(target)) {
                if (value == 2 * target && map.get(target) < 2) {
                    continue;
                } else
                    return true;
            }
        }
        return false;
    }
}
