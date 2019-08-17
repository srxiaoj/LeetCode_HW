import java.util.*;

/**
 * Created by Administrator on 2016/10/19.
 */
public class FrogJump {
    public static void main(String[] args) {
        // System.out.println(canCross(new int[]{0, 1, 3, 5, 6, 8, 12, 17}));
        // System.out.println(canCross(new int[]{0, 1, 2, 3, 4, 8, 9, 11}));
    }


    /**
     * O(n^2)
     */
    /*public static boolean canCross(int[] stones) {
        if (stones == null || stones.length == 0) return false;
        if (stones.length < 2) return true;
        if (stones[1] != 1) return false;

        int n = stones.length;
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < stones.length; i++) {
            map.put(stones[i], new HashSet<>());
        }
        map.get(0).add(1);
        for (int i = 0; i < n - 1; i++) {
            for (int last : map.get(stones[i])) {
                int next = last + stones[i];
                if (next == stones[n - 1]) return true;
                if (map.containsKey(next)) {
                    map.get(next).add(last);
                    map.get(next).add(last + 1);
                    if (last - 1 > 0) map.get(next).add(last - 1);
                }
            }
        }
        return false;
    }*/
}
