import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by thanksgiving on 1/9/16.
 */
public class FactorCombinations {
    public static void main(String[] args) {
        FactorCombinations obj = new FactorCombinations();
        System.out.println(obj.getFactors(32));
    }

    /**
     * My idea is that the results are coming from the combination of the factors of the number, thus we can pre-compute
     * the factors and save them in a list, therefore later we just need to pick element from this factor list.
     *
     * @param n
     * @return
     */

    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> factors = new ArrayList<Integer>();
        // pre compute the factor list
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                if (i * i == n) {
                    factors.add(i);
                } else {
                    factors.add(i);
                    factors.add(n / i);
                }
            }
        }
        if (factors.size() == 0) {
            return result;
        }
        Collections.sort(factors);
        System.out.println("factor list is: " + factors);
        List<Integer> part = new ArrayList<Integer>();
        getFactorsHelper(result, part, factors, n, 0);
        return result;
    }

    public void getFactorsHelper(List<List<Integer>> result, List<Integer> part, List<Integer> factors, int target, int start) {
        if (target == 1) {
            List<Integer> out = new ArrayList<Integer>(part);
            result.add(out);
            return;
        }
        for (int i = start; i < factors.size(); i++) {
            int num = factors.get(i);
            part.add(num);
            if (target % num == 0) {
                getFactorsHelper(result, part, factors, target / num, i);
            }
            part.remove(part.size() - 1);
        }
    }


/*
    // slow
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> part = new ArrayList<>();
        dfs(n, res, part, 1, 2);
        return res;
    }

    private void dfs(int n, List<List<Integer>> res, List<Integer> part, int product, int start) {
        if (product == n) {
            List<Integer> list = new ArrayList<>(part);
//            Collections.sort(list);
//            if (!res.contains(list))
            res.add(list);
            return;
        }
        for (int i = start; i <= n / 2; i++) {
            if (n % (product * i) == 0) {
                part.add(i);
                dfs(n, res, part, product * i, i);
                part.remove(part.size() - 1);
            }
        }
    }
    */

}
