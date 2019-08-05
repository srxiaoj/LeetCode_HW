public class AddBinary {

  public static void main(String[] args) {
    AddBinary obj = new AddBinary();
    String a = "11";
    String b = "0";
    System.out.println(obj.addBinary(a, b));

  }

  public String addBinary(String a, String b) {
    int m = a.length(), n = b.length();
    int len = Math.max(m, n);
    int[] res = new int[len + 1];
    int i = m - 1, j = n - 1;
    while (i >= 0 || j >= 0) {
      int digit = 0;
      if (i >= 0) {
        digit += a.charAt(i) - '0';
      }
      if (j >= 0) {
        digit += b.charAt(j) - '0';
      }
      // System.out.println("before");
      // printArray(res);
      int index = Math.max(i, j) + 1;
      // System.out.printf("index = %s, digit = %s\n", index, digit);
      // System.out.printf("res[index] + digit = %s\n", res[index] + digit);
      res[index - 1] = (res[index] + digit) / 2;
      res[index] = (res[index] + digit) % 2;
      i--;
      j--;
      // System.out.println("after");
      // printArray(res);
    }

    StringBuilder sb = new StringBuilder();
    int start = 0;
    if (res[0] == 0) {
      start++;
    }
    for (int z = start; z <= res.length - 1; z++) {
      sb.append(res[z]);
    }
    return sb.toString();
  }

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

  // /**
  //  * 从右往左两位相加，如果大于1则进位
  //  */
  // public String addBinary(String a, String b) {
  //     if (a == null || a.length() == 0) return b;
  //     if (b == null || b.length() == 0) return a;
  //     int m = a.length(), n = b.length();
  //     if (m < n) return addBinary(b, a);
  //
  //     int i = n - 1;
  //     String res = "";
  //     int sum = 0;
  //     while (i >= 0) {
  //         int digitA = a.charAt(i + m - n) - '0';
  //         int digitB = b.charAt(i) - '0';
  //         sum += digitA + digitB;
  //         res = (sum % 2) + res;
  //         sum /= 2;
  //         i--;
  //     }
  //     while ((m - n + i) >= 0) {
  //         int digitA = a.charAt(i + m - n) - '0';
  //         sum += digitA;
  //         res = (sum % 2) + res;
  //         sum /= 2;
  //         i--;
  //     }
  //     if (sum == 1) {
  //         res = 1 + res;
  //     }
  //     return res;
  // }
}
