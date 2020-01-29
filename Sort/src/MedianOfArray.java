import java.util.PriorityQueue;

public class MedianOfArray {

  public static void main(String[] args) {
    int[] nums = new int[]{5, 8, 3, 1, 6};
    System.out.println(getMedian2(nums));

    int[] nums2 = new int[]{13, 5, 8, 10};
    System.out.println(getMedian2(nums2));
  }

  // 方法二，保持一个(l + r ) / 2 + 1 size的最小堆，然后不断更新这个最小堆的值
  private static int getMedian2(int[] nums) {
    int l = 0, r = nums.length;
    int size = (l + r) / 2 + 1;
    PriorityQueue<Integer> pq = new PriorityQueue<>(size);

    for (int i = 0; i < size; i++) {
      pq.offer(nums[i]);
    }
    System.out.println(pq);

    for (int i = size; i < r; i++) {
      if (pq.peek() < nums[i]) {
        pq.poll();
        pq.offer(nums[i]);
      }
    }
    System.out.println(pq);
    if (r % 2 == 0) {
      return (pq.poll() + pq.poll()) / 2;
    } else {
      return pq.poll();
    }
  }

  // 方法一: partition
  private static int getMedian(int[] nums) {
    int l = 0, r = nums.length;
    if (nums.length % 2 == 0) {
      int left = (l + r) / 2 - 1;
      int right = (l + r) / 2;
      return (getKthLargest(nums, left) + getKthLargest(nums, right)) / 2;
    } else {
      return getKthLargest(nums, (l + r) / 2);
    }
  }

  private static int getKthLargest(int[] nums, int k) {
    int l = 0, r = nums.length - 1;
    int mid = 0;
    while (mid != k) {
      mid = partition(nums, l, r);
      if (mid == k) {
        return nums[mid];
      }
      if (mid < k) {
        l = mid + 1;
      } else {
        r = mid - 1;
      }
    }
    return 0;
  }

  private static int partition(int[] nums, int start, int end) {
    int p = start;
    int pVal = nums[start];
    int l = start;

    for (int i = start + 1; i <= end; i++) {
      if (nums[i] > pVal) {
        p++;
        swap(nums, i, p);
      }
    }
    swap(nums, p, l);
    Utils.printArray(nums);
    return p;
  }

  private static void swap(int[] array, int a, int b) {
    int temp = array[a];
    array[a] = array[b];
    array[b] = temp;
  }
}
