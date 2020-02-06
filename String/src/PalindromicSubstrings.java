public class PalindromicSubstrings {

  public static void main(String[] args) {
    PalindromicSubstrings obj = new PalindromicSubstrings();
    System.out.println(obj.countSubstrings("abc"));
    System.out.println(obj.countSubstrings("aaa"));
  }

  public int countSubstrings(String s) {
    if (s == null || s.length() < 1) {
      return 0;
    }
    int[] num = new int[]{0};
    for (int i = 0; i < s.length(); i++) {
      findMaxLen(s, i, i, num);
      findMaxLen(s, i, i + 1, num);
    }
    return num[0];
  }

  private void findMaxLen(String s, int l, int r, int[] num) {
    while (l >= 0 && r < s.length() && s.charAt(r) == s.charAt(l)) {
      num[0]++;
      l--;
      r++;
    }
  }
}
