import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Combination {
    public static void main(String[] args) {
        /**
         * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
         * for example,
         * If n = 4 and k = 2, a solution is:
         * [[2,4],[3,4],[2,3],[1,2],[1,3],[1,4]]
         */

        List<List<Integer>> A = combine(4, 3);
        printArray(A);
    }

    public List<List<Integer>> combine2(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> part = new ArrayList<>();
        helper(res, part, n, k, 1);
        return res;
    }

    public void helper(List<List<Integer>> res, List<Integer> part, int n, int k, int start) {
        if (part.size() == k) {
            res.add(new ArrayList<>(part));
            return;
        }

        for (int i = start; i <= n; i++) {
            List<Integer> newPart = new ArrayList<>(part);
            newPart.add(i);
            helper(res, newPart, n, k, i + 1);
        }
    }

    /**
     * 每一层在上一层的基础上加一个更大的element
     * start: []
     * add 1st level: [1, 2, 3, 4]
     * add 2nd level: [[1,2],[1,3],[2,3],[1,4],[2,4],[3,4]
     * add 3rd level: [[1,2,3],[1,2,4],[1,3,4],[2,3,4]
     *
     * @param n
     * @param k
     * @return
     */
    public static List<List<Integer>> combine(int n, int k) {
        if (n == 0 || k == 0 || k > n)
            return null;
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for (int i = 1; i <= n; i++) {
            res.add(Arrays.asList(i)); // get the array for the first element
        }

        for (int i = 2; i <= k; i++) { // iterate all the combination numbers
            List<List<Integer>> tmp = new ArrayList<List<Integer>>();
            for (int j = i; j <= n; j++) {
                for (List<Integer> list : res) {
                    // System.out.println("list is: " + list);
                    // if new value is larger than the largest value
                    // in the previous list, then add this value to
                    // the larger dimension list
                    if (list.get(list.size() - 1) < j) {
                        List<Integer> newList = new ArrayList<Integer>(list);
                        newList.add(j);
                        tmp.add(newList);
                    }
                }
            }
            res = tmp;
        }
        return res;
    }


    public static void printArray(List<List<Integer>> A) {
        for (int i = 0; i < A.size(); i++) {
            System.out.print(A.get(i) + " ");
        }
    }

}
