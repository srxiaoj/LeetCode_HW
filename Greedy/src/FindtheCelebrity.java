public class FindtheCelebrity {

  public static void main(String[] args) {

  }

  public int findCelebrity(int n) {
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        // i knows j, or j doesn't know i, both make i not celebrity
        if (i != j && (knows(i, j) || !knows(j, i))) {
          break;
        }
        if (j == n - 1) {
          return i;
        }
      }
    }
    return -1;
  }

  private boolean knows(int a, int b) {
    return true;
  }
}
