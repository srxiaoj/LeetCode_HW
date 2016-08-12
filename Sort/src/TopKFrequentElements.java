import java.util.*;

/**
 * Created by thanksgiving on 7/20/16.
 */
public class TopKFrequentElements {
    public static void main(String[] args) {
        int[] a = {1, 1, 1, 2, 2, 3};
        System.out.println(topKFrequent2(a, 2));
    }

    /**
     * bucket sort
     * 不要用Arrays.fill(a, new ArrayList<>()) !!!
     */
    public static List<Integer> topKFrequent2(int[] nums, int k) {
        List<Integer> res = new ArrayList<>(k);
        if (k == 0 || nums.length == 0) return res;

        int n = nums.length;
        List<Integer>[] a = new List[n + 1];
//        Arrays.fill(a, new ArrayList<>());
        for (int i = 0; i < a.length; i++) {
            a[i] = new ArrayList<>();
        }
        int i = 0;
        Map<Integer, Integer> map = new HashMap<>();
        while (i < n) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
            i++;
        }
        for (int key : map.keySet()) {
            a[map.get(key)].add(key);
        }
        for (i = n; i >= 0; i--) {
            for (int key : a[i]) {
                if (res.size() < k)
                    res.add(key);
            }
        }
        return res;


      /*  List<Integer>[] bucket = new List[nums.length + 1];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        for (int key : map.keySet()) {
            int frequency = map.get(key);
            if (bucket[frequency] == null) {
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(key);
        }

        List<Integer> res = new ArrayList<>();

        for (int pos = bucket.length - 1; pos >= 0 && res.size() < k; pos--) {
            if (bucket[pos] != null) {
                res.addAll(bucket[pos]);
            }
        }
        return res;*/
    }

    public static List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, 1);
            } else {
                map.put(num, map.get(num) + 1);
            }
        }

//        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<Map.Entry<Integer, Integer>>((o1, o2) -> o2.getValue() - o1.getValue());
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<Map.Entry<Integer, Integer>>(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });
        pq.addAll(map.entrySet());

        List<Integer> ret = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            ret.add(pq.poll().getKey());
        }
        return ret;
    }

    //print array
    public static void printArray(List[] A) {
        System.out.print("[");
        for (int i = 0; i < A.length; i++) {
            if (i != A.length - 1)
                System.out.print(A[i] + ", ");
            else
                System.out.print(A[i]);
        }
        System.out.println("]");
    }
}
