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

  public static int minimumTotal(List<List<Integer>> t) {
    if (t == null || t.size() == 0) {
      return 0;
    }
    int n = t.get(t.size() - 1).size();
    int[] dp = new int[n];
    for (int i = 0; i < n; i++) {
      for (int j = i; j >= 0; j--) {
        if (j == 0) {
          dp[j] = dp[j] + t.get(i).get(j);
        } else if (j == i) {
          dp[j] = dp[j - 1] + t.get(i).get(j);
        } else {
          dp[j] = Math.min(dp[j], dp[j - 1]) + t.get(i).get(j);
        }
      }
      printArray(dp);
    }
    int min = Integer.MAX_VALUE;
    for (int i = 0; i < n; i++) {
      min = Math.min(min, dp[i]);
    }
    return min;
  }

  /*public static int minimumTotal(List<List<Integer>> triangle) {
    int n = triangle.size();
    int[] results = new int[n + 1];

    for (int i = n - 1; i >= 0; i--) {
      List<Integer> tmp = triangle.get(i);

      for (int j = 0; j < tmp.size(); j++) {
        results[j] = Math.min(results[j], results[j + 1]) + tmp.get(j);
      }
    }
    return results[0];
  }*/


  //print array
  public static void printArray(int[] A) {
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
