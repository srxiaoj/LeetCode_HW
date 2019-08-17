public class Utils<T> {

  //print array generic type
  public static <T> void printArray(T[] A) {
    System.out.print("[");
    for (int i = 0; i < A.length; i++) {
      if (i != A.length - 1) {
        System.out.print(A[i] + ", ");
      } else {
        System.out.print(A[i]);
      }
    }
    System.out.println("]");
  }

  //print array
  public static void printArray(int[] A) {
    System.out.print("[");
    for (int i = 0; i < A.length; i++) {
      if (i != A.length - 1) {
        System.out.print(A[i] + ", ");
      } else {
        System.out.print(A[i]);
      }
    }
    System.out.println("]");
  }

  //print 2d array generic type
  public static <T> void print2dArray(T[][] A) {
    for (int i = 0; i < A.length; i++) {
      for (int j = 0; j < A[i].length; j++) {
        if (j != A[i].length - 1) {
          System.out.print(A[i][j] + ", ");
        } else {
          System.out.print(A[i][j]);
        }

      }
      System.out.println("");
    }
    System.out.println("");
  }

  //print 2d array
  public static void print2dArray(int[][] A) {
    for (int i = 0; i < A.length; i++) {
      for (int j = 0; j < A[i].length; j++) {
        if (j != A[i].length - 1) {
          System.out.print(A[i][j] + ", ");
        } else {
          System.out.print(A[i][j]);
        }

      }
      System.out.println("");
    }
    System.out.println("");
  }
}
