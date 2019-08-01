import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PermutationsII {

  public static void main(String[] args) {
    int[] nums = {1, 2, 1};
    List<List<Integer>> res = permute(nums);
    printArray(res);
  }

  public static List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    Arrays.sort(nums);
    boolean[] visited = new boolean[nums.length];
    helper(res, new ArrayList<>(), nums, visited);
    return res;
  }

  private static void helper(List<List<Integer>> res, List<Integer> part, int[] nums,
      boolean[] visited) {
    if (part.size() == nums.length) {
      res.add(part);
      return;
    }

    for (int i = 0; i < nums.length; i++) {
      List<Integer> newPart = new ArrayList<>(part);
      if (visited[i]) {
        continue;
      }
      if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
        continue;
      }
      visited[i] = true;
      newPart.add(nums[i]);
      helper(res, newPart, nums, visited);
      visited[i] = false;
    }
  }


  /**
   * 方法2 套用next permute方法，一直循环找下一个permute number直到出现重复组合 需要将int[] 转换为List<Integer>
   */
  public static List<List<Integer>> permute2(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> input = arrayToList(nums);

    while (!res.contains(input)) {
      List<Integer> newList = new ArrayList<>(input);
      res.add(newList);
//            System.out.println("before permute " + input);
//            System.out.println("res is ");
//            printArray(res);
      input = nextPermu(input);
//            System.out.println("after permute " + input);
//            System.out.println("res is ");
//            printArray(res);
    }
    return res;
  }

  /**
   * get next larger permutation.
   */
  public static List<Integer> nextPermu(List<Integer> list) {
    for (int i = list.size() - 1; i > 0; i--) {
      if (list.get(i - 1) < list.get(i)) {
        Collections.sort(list.subList(i, list.size()));
        for (int j = i; j < list.size(); j++) {
          if (list.get(j) > list.get(i - 1)) {
            Collections.swap(list, j, i - 1);
            return list;
          }
        }
      }
    }
    Collections.sort(list);
    return list;
  }

  private static List<Integer> arrayToList(int[] nums) {
    List<Integer> input = new ArrayList<Integer>();
    for (int i = 0; i < nums.length; i++) {
      input.add(nums[i]);
    }
    return input;
  }

  public static void printArray(List<List<Integer>> A) {
    for (int i = 0; i < A.size(); i++) {
      System.out.print(A.get(i) + " ");
    }
    System.out.println("");
  }
}
