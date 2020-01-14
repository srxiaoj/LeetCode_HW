import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicates {

  public static void main(String[] args) {
    int[] nums = new int[]{4, 3, 2, 7, 8, 2, 3, 1};
    System.out.println(findDuplicates(nums));
  }

  public static List<Integer> findDuplicates(int[] nums) {
    List<Integer> res = new ArrayList<>();
    for (int i : nums) {
      int index = Math.abs(i);
      if (nums[index - 1] < 0) {
        res.add(index);
      } else {
        nums[index - 1] *= -1;
      }
    }
    return res;
  }
}
