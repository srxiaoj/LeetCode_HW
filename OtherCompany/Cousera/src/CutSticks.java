import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * You are given  sticks, where the length of each stick is a positive integer. A cut operation is performed on the sticks such that all of them are reduced by the length of the smallest stick.

 Suppose we have six sticks of the following lengths:

 5 4 4 2 2 8
 Then, in one cut operation we make a cut of length 2 from each of the six sticks. For the next cut operation four sticks are left (of non-zero length), whose lengths are the following:

 3 2 2 6
 The above step is repeated until no sticks are left.

 Given the length of  sticks, print the number of sticks that are left before each subsequent cut operations.

 Note: For each cut operation, you have to recalcuate the length of smallest sticks (excluding zero-length sticks).

 Input Format
 The first line contains a single integer .
 The next line contains  integers: a0, a1,...aN-1 separated by space, where  represents the length of the  stick.

 Output Format
 For each operation, print the number of sticks that are cut, on separate lines.

 Constraints

 Sample Input 0

 6
 5 4 4 2 2 8
 Sample Output 0

 6
 4
 2
 1
 */
public class CutSticks {
    public static void main(String[] args) {
        int[] nums = {5, 4, 4, 2, 2, 8};
        System.out.println(getCutLength(nums));

        int[] nums2 = {1, 2, 3, 4, 3, 3, 2, 1};
        System.out.println(getCutLength(nums2));
    }

    public static List<Integer> getCutLength(int[] nums) {
        int n = nums.length;
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        for (int i : nums) {
            treeMap.put(i, treeMap.getOrDefault(i, 0) + 1);
        }
        List<Integer> res = new ArrayList<>();
        res.add(n);
        System.out.println(treeMap);
        for (Integer key : treeMap.keySet()) {
            n -= treeMap.get(key);
            res.add(n);
        }
        res.remove(res.size() - 1);
        return res;
    }
}
