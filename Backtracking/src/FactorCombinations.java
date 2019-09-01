import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by thanksgiving on 1/9/16.
 */
public class FactorCombinations {

  public static void main(String[] args) {
    FactorCombinations obj = new FactorCombinations();
    System.out.println(obj.getFactors(6));
  }

  /**
   * My idea is that the results are coming from the combination of the factors of the number, thus
   * we can pre-compute the factors and save them in a list, therefore later we just need to pick
   * element from this factor list.
   */
  public List<List<Integer>> getFactors(int n) {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> part = new ArrayList<>();

    List<Integer> factors = new ArrayList<>();
    for (int i = 2; i * i <= n; i++) {
      if (i * i == n) {
        factors.add(i);
      } else if (n % i == 0) {
        factors.add(i);
        factors.add(n / i);
      }
    }
    dfs(res, part, factors, 0, n);
    return res;
  }

  private void dfs(List<List<Integer>> res, List<Integer> part, List<Integer> factors, int index,
      int n) {
    if (n == 1) {
      res.add(part);
      return;
    }

    for (int i = index; i < factors.size(); i++) {
      if (n % factors.get(i) == 0) {
        List<Integer> newPart = new ArrayList<>(part);
        newPart.add(factors.get(i));
        dfs(res, newPart, factors, i, n / factors.get(i));
      }
    }
  }


/*
    // slow
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> part = new ArrayList<>();
        helper(res, part, n, 1, 2);
        return res;
    }

    public void helper(List<List<Integer>> res, List<Integer> part, int n, int total, int start) {
        if (total > n || n == 1) return;
        if (total == n) {
            res.add(new ArrayList<>(part));
            return;
        }

        for (int i = start; i <= n / 2; i++) {
            if (n / total % i == 0) {
                List<Integer> newPart = new ArrayList<>(part);
                newPart.add(i);
                helper(res, newPart, n, total * i, start + 1);
            }
        }
    }
    */

}
