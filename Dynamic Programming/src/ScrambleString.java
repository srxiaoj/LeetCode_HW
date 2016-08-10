
public class ScrambleString{
	public static void main(String[] args) {
		System.out.println(isScramble("great", "regat"));
        System.out.println(isScramble("great", "rgeat"));
        System.out.println(isScramble("great", "rgtae"));
        System.out.println(isScramble("eat", "tae"));
        System.out.println(isScramble("ea", "ae"));
        System.out.println(isScramble("abb", "bab"));
        System.out.println(isScramble("abc", "bac"));
        System.out.println(isScramble("abc", "bca"));
	}

    public static boolean isScramble(String s1, String s2) {
        if (s1.isEmpty()) return s2.isEmpty();
        if (s1.equals(s2)) return true;
        if (s1.length() != s2.length()) return false;
        int n = s1.length();

        String s1Left = s1.substring(0, n / 2);
        String s1Right = s1.substring(n / 2);
        String s2Left = s2.substring(0, n / 2);
        String s2Right = s2.substring(n / 2);
        String s1ReverseLeft = s1.substring(0, (n + 1) / 2);
        String s1ReverseRight = s1.substring((n + 1) / 2);
        String s2ReverseLeft = s2.substring(0, (n + 1) / 2);
        String s2ReverseRight = s2.substring((n + 1) / 2);
        if ((s1Right + s1Left).equals(s2)) return true;
        return helper(s1, s2);
    }


    public static boolean helper(String s1, String s2) {
		if (s1.isEmpty()) return s2.isEmpty();
        if (s1.equals(s2)) return true;
        if (s1.length() != s2.length()) return false;
		int n = s1.length();
		if (n == 1) return s1.equals(s2);
		if (n == 2) {
			return s1.equals(s2) || s1.charAt(0) == s2.charAt(1) && s1.charAt(1) == s2.charAt(0);
		}

		String s1Left = s1.substring(0, n / 2);
		String s1Right = s1.substring(n / 2);
		String s2Left = s2.substring(0, n / 2);
		String s2Right = s2.substring(n / 2);
        String s1ReverseLeft = s1.substring(0, (n + 1) / 2);
        String s1ReverseRight = s1.substring((n + 1) / 2);
        String s2ReverseLeft = s2.substring(0, (n + 1) / 2);
        String s2ReverseRight = s2.substring((n + 1) / 2);
		return helper(s1Left, s2Left) && helper(s1Right, s2Right)
                || helper(s1ReverseLeft, s2Right) && helper(s1ReverseRight, s2Left)
                || helper(s1ReverseLeft, s2ReverseLeft) && helper(s1ReverseRight, s2ReverseRight);
	}





/*	public static boolean helper(String s1, String s2) {
        if(s1.length() != s2.length()) return false;
        if(s1.length() == 0) return false;
        return helper(s2, 0, s2.length() -1, s1, 0, s1.length()-1);
    }

    private static boolean helper(String s1, int begs1, int ends1, String s2, int begs2, int ends2){
        if(ends1==begs1 && s1.charAt(begs1) == s2.charAt(begs2)) return true;
        int chars[]= new int[256];
        for(int i=begs1;i<=ends1;++i){
            chars[s1.charAt(i)]++;
        }
        for(int i=begs2;i<=ends2;++i){
            chars[s2.charAt(i)]--;
        }
        for(int i=0;i<256;++i){
            if(chars[i]!=0) return false;
        }
        for(int i =begs1; i<ends1; i++){
        	//first i character in s1 matches the scramble of last i in s2 and the next ends1-i in s1 matches the
        	//first ends1-i in s2
            if(helper(s1, begs1, i, s2, ends2-i+begs1, ends2)
            && helper(s1, i+1, ends1, s2, begs2, begs2 + ends1 - i -1)) return true;
            //first i character in s1 matches the scramble of first i in s2 and the next ends1-i in s1 matches the
            //next ends1-i in s2
            if(helper(s1, begs1, i, s2, begs2, i-begs1 + begs2)
            && helper(s1, i+1, ends1, s2, i+1-begs1+begs2, ends2)) return true;
        }
        return false;
    }*/
}