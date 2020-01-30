import java.util.HashMap;
import java.util.Map;

public class SubArraySumEqualsK {
  public static void main(String[] args) {
    SubArraySumEqualsK obj = new SubArraySumEqualsK();
    int[] a = new int[]{1,1,1};
    System.out.println(obj.subarraySum(a, 2));

    int[] b = new int[]{0,0,0,0,0};
    System.out.println(obj.subarraySum(b, 0));
  }

  public int subarraySum(int[] nums, int k) {
    int sum = 0;
    int count = 0;
    if (nums == null || nums.length == 0) {
      return sum;
    }

    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];
      if (sum == k) {
        count++;
      }
      if (map.containsKey(sum - k)) {
        count += map.get(sum - k);
      }

      if (map.containsKey(sum)) {
        map.put(sum, map.get(sum) + 1);
      } else {
        map.put(sum, 1);
      }
    }
    return count;
  }

}
