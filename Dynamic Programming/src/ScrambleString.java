
public class ScrambleString{
	public static void main(String[] args) {
		String s1 = "great";
		String s2 = "regat";
		System.out.println(isScramble(s1, s2));
	}
	public static boolean isScramble(String s1, String s2) {
        if(s1.length() != s2.length()) return false;
        if(s1.length() == 0) return false;
        return isScramble(s2, 0, s2.length() -1, s1, 0, s1.length()-1);
    }

    private static boolean isScramble(String s1, int begs1, int ends1, String s2, int begs2, int ends2){
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
            if(isScramble(s1, begs1, i, s2, ends2-i+begs1, ends2)
            && isScramble(s1, i+1, ends1, s2, begs2, begs2 + ends1 - i -1)) return true;
            //first i character in s1 matches the scramble of first i in s2 and the next ends1-i in s1 matches the
            //next ends1-i in s2
            if(isScramble(s1, begs1, i, s2, begs2, i-begs1 + begs2)
            && isScramble(s1, i+1, ends1, s2, i+1-begs1+begs2, ends2)) return true;
        }
        return false;
    }
}