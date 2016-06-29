import java.util.HashSet;
import java.util.Set;

/**
 * Created by thanksgiving on 6/29/16.
 */
public class AllStringSetsIdentical {
    public static void main(String[] args) {
        // test functions
        System.out.println(allStringSetsIdentical(new String[][]{{"a", "b"}, {"b", "b", "a"}, {"b", "a"}}));
        System.out.println(allStringSetsIdentical(new String[][]{{"a", "b"}, {"a"}, {"b"}}));
    }

    public static boolean allStringSetsIdentical(String[][] sets) {
        if (sets == null || sets.length == 0) return false;
        int n = sets.length;
        Set<String> firstSet = arrayToSet(sets[0]);

        for (int i = 1; i < n; i++) {
            Set<String> nextSet = arrayToSet(sets[i]);
            if (!nextSet.equals(firstSet)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Helper method to convert an array to a set.
     * @param arr
     * @return
     */
    private static Set<String> arrayToSet(String[] arr) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }
        return set;
    }
}
