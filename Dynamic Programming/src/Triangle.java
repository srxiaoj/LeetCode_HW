import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Triangle {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        List<List<Integer>> list = new ArrayList<>();
        list.add(Arrays.asList(2));
        list.add(Arrays.asList(3, 4));
        list.add(Arrays.asList(6, 5, 7));
        list.add(Arrays.asList(4, 1, 8, 3));
        System.out.println(minimumTotal(list));
//        List<List<Integer>> list2 = new ArrayList<>();
//        System.out.println(minimumTotal(list2));
    }
    public static int minimumTotal(List<List<Integer>> triangle) {
        int sz = triangle.size();
        int[] results = new int[sz+1];

        for(int i=sz-1; i>=0; i--) {
            List<Integer> tmp = triangle.get(i);

            for(int j=0; j<tmp.size(); j++) {
                results[j] = Math.min(results[j], results[j+1]) + tmp.get(j);
            }
        }
        return results[0];
    }
}
