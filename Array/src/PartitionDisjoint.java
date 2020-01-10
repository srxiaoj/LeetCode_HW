public class PartitionDisjoint {

  public static void main(String[] args) {
    int[] a = new int[]{5, 0, 3, 8, 6};
    // System.out.println(partitionDisjoint(a));

    // int[] b = new int[]{18,14,2,8,10,0,5,17,4,18,4,16,68,49};
    // System.out.println(partitionDisjoint(b));

    int[] c = new int[]{1, 1};
    System.out.println(partitionDisjoint(c));
  }

  public static int partitionDisjoint2(int[] A) {
    int pos = 0;
    int leftMax = A[0];
    int tmpMax = A[0];
    for (int i = 0; i < A.length; i++) {
      tmpMax = Math.max(tmpMax, A[i]);
      if (leftMax > A[i]) {
        pos = i;
        leftMax = tmpMax;
      }
    }
    return pos + 1;
  }

  // wrong
  public static int partitionDisjoint(int[] A) {
    int n = A.length;
    int[] left = new int[n];
    int[] right = new int[n];
    left[0] = A[0];
    right[n - 1] = A[n - 1];
    for (int i = 1; i < n; i++) {
      if (A[i] <= left[i - 1]) {
        left[i] = left[i - 1];
      } else {
        left[i] = A[i];
      }
    }

    for (int i = n - 2; i >= 0; i--) {
      if (A[i] < right[i + 1]) {
        right[i] = A[i];
      } else {
        right[i] = right[i + 1];
      }
    }

    Utils.printArray(left);
    Utils.printArray(right);
    for (int i = 1; i < n; i++) {
      if (A[i] > left[i - 1] && A[i - 1] <= right[i]) {
        return i;
      }
    }
    return 0;
  }
}
