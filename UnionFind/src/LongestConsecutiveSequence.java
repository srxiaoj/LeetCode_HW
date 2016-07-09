import java.util.HashMap;
import java.util.Map;

/**
 * Created by thanksgiving on 7/9/16.
 */
public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        int[] a = {100, 4, 200, 1, 3, 2};
        System.out.println(longestConsecutiveUF(a));
    }

    /**
     * Union Find solution
     */
    public static int longestConsecutiveUF(int[] nums) {
        unionFind uf = new unionFind(nums.length);
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(); // <value,index>
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                continue;
            }
            map.put(nums[i], i);
            if (map.containsKey(nums[i] + 1)) {
                uf.union(i, map.get(nums[i] + 1));
            }
            if (map.containsKey(nums[i] - 1)) {
                uf.union(i, map.get(nums[i] - 1));
            }
        }
        return uf.maxUnion();
    }

    private static class unionFind {
        private int[] father;

        public unionFind(int n) {
            father = new int[n];
            for (int i = 0; i < n; i++) {
                father[i] = i;
            }
        }

        private int find(int node) {
            while (node != father[node]) {
                father[node] = father[father[node]];
                node = father[node];
            }
            return node;
        }

        public boolean connected(int i, int j) {
            return find(i) == find(j);
        }

        public void union(int p, int q) {
            int i = find(p);
            int j = find(q);
            father[i] = j;
        }

        // returns the maxium size of union
        public int maxUnion() { // O(n)
            int[] count = new int[father.length];
            int max = 0;
            for (int i = 0; i < father.length; i++) {
                count[find(i)]++;
                max = Math.max(max, count[find(i)]);
            }
            return max;
        }
    }

    /**
     * O(n) using HashMap to store the length for the left most and right most bounndary
     */
    public static int longestConsecutive(int[] num) {
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int n : num) {
            if (!map.containsKey(n)) {
                int left = (map.containsKey(n - 1)) ? map.get(n - 1) : 0;
                int right = (map.containsKey(n + 1)) ? map.get(n + 1) : 0;
                // sum: length of the sequence n is in
                int sum = left + right + 1;
                map.put(n, sum);

                // keep track of the max length
                res = Math.max(res, sum);

                // extend the length to the boundary(s)
                // of the sequence
                // will do nothing if n has no neighbors
                map.put(n - left, sum);
                map.put(n + right, sum);
            } else {
                // duplicates
                continue;
            }
        }
        return res;
    }
}
