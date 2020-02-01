/**
 * Created by thanksgiving on 4/30/16.
 */
public class SearchforaRange {

  public static void main(String[] args) {
    SearchforaRange obj = new SearchforaRange();
    int[] a = {1, 2, 5, 7, 7, 8};
    System.out.println(obj.searchRange(a, 7)[0]);
    System.out.println(obj.searchRange(a, 7)[1]);
  }

  /**
   * 先找到range左boundary， 然后再找range右boundary nums[mid] == target时: 找左boundary时用end = mid,
   * 右boundary用start = mid
   */
  public int[] searchRange(int[] nums, int target) {
    int[] res = new int[]{-1, -1};
    if (nums == null || nums.length == 0) return res;
    int l = 0, r = nums.length - 1;
    while (l + 1 < r) {
      int mid = (l + r) / 2;
      // nums[mid] < target, 则边界一定在mid右边
      if (nums[mid] < target) {
        l = mid;
      } else {
        r = mid;
      }
    }

    if (nums[l] == target) {
      res[0] = l;
    } else if (nums[r] == target) {
      res[0] = r;
    } else {
      return res;
    }

    l = res[0];
    r = nums.length - 1;
    while (l + 1 < r) {
      int mid = (l + r) / 2;
      if (nums[mid] > target) {
        r = mid;
      } else {
        l = mid;
      }
    }

    if (nums[r] == target) {
      res[1] = r;
    } else if (nums[l] == target) {
      res[1] = l;
    }
    return res;
  }

  // public int[] searchRange(int[] nums, int target) {
  //   int[] targetRange = {-1, -1};
  //
  //   int leftIdx = extremeInsertionIndex(nums, target, true);
  //
  //   // assert that `leftIdx` is within the array bounds and that `target`
  //   // is actually in `nums`.
  //   if (leftIdx == nums.length || nums[leftIdx] != target) {
  //     return targetRange;
  //   }
  //
  //   targetRange[0] = leftIdx;
  //   targetRange[1] = extremeInsertionIndex(nums, target, false) - 1;
  //
  //   return targetRange;
  // }
  //
  // private int extremeInsertionIndex(int[] nums, int target, boolean left) {
  //   int lo = 0;
  //   int hi = nums.length;
  //
  //   while (lo < hi) {
  //     int mid = (lo + hi) / 2;
  //     if (nums[mid] > target || (left && target == nums[mid])) {
  //       hi = mid;
  //     } else {
  //       lo = mid + 1;
  //     }
  //   }
  //
  //   return lo;
  // }
}
