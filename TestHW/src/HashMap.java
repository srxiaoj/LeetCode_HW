import java.util.Map;

/**
 * Created by thanksgiving on 4/26/16.
 */
public class HashMap {
    public static void main(String[] args) {
        Map<Integer, int[]> map = new java.util.HashMap<>();
        int[] a1 = {1};
        map.put(2, a1);
        map.get(2)[0] = 1;
        System.out.println(map.get(2)[0]);
    }
}
