import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MajorityElement {

  public static void main(String[] args) {
    int[] test = {3, 2, 3};
    System.out.println(majorityElement3(test));
  }

  /**
   * sorting
   */
  public static int majorityElement1(int[] nums) {
    Arrays.sort(nums);
    return nums[nums.length / 2];
  }

  /**
   * Hashtable
   */
  public static int majorityElement2(int[] nums) {
    Map<Integer, Integer> myMap = new HashMap<>();
    int res = 0;
    for (int num : nums) {
      if (!myMap.containsKey(num)) {
        myMap.put(num, 1);
      } else {
        myMap.put(num, myMap.get(num) + 1);
      }
      if (myMap.get(num) > nums.length / 2) {
        res = num;
        break;
      }
    }
    return res;
  }

  /**
   * Moore voting algorithm
   */
  public static int majorityElement3(int[] nums) {
    int count = 0, vote = 0;
    for (int num : nums) {
      if (count == 0) {
        vote = num;
      }

      if (num != vote) {
        count--;
      } else {
        count++;
      }
      System.out.printf("vote = %s, count = %s\n", vote, count);
    }
    return vote;
  }

  /**
   * Bit manipulation
   */
  public static int majorityElement(int[] nums) {
    int[] bit = new int[32];
    for (int num : nums) {
      for (int i = 0; i < 32; i++) {
        if (((num >> (31 - i)) & 1) == 1) {
          bit[i]++;
        }
      }
    }
    int res = 0;
    for (int i = 0; i < 32; i++) {
      bit[i] = bit[i] > nums.length / 2 ? 1 : 0;
      res += bit[i] * (1 << (31 - i));
    }
    return res;
  }

  /**
   * Bit manipulation 2
   */
  public static int majorityElement4(int[] num) {
    int res = 0;
    for (int i = 0; i < 32; i++) {
      int ones = 0, zeros = 0;
      for (int j = 0; j < num.length; j++) {
        int tmp = 1 << i;
        if ((num[j] & tmp) != 0) {
          ++ones;
        } else {
          ++zeros;
        }
      }
      if (ones > zeros) {
        res |= (1 << i);
      }
    }
    return res;
  }
}
