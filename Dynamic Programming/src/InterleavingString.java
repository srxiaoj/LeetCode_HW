
public class InterleavingString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "aabcc";
		String s2 = "dbbca";
		String s3 = "aadbbbaccc";
		System.out.println(isInterleave(s1, s2, s3));
	}
	public static boolean isInterleave(String s1, String s2, String s3) {
		if (s3.length() != s1.length() + s2.length()) return false;

	    boolean[] optimal = new boolean[s2.length() + 1];    //dp optimal
	    optimal[0] = true;
	    for (int j = 0; j < s2.length(); j++) { //check no s1 char is selected, if s2 could equals to s3
	        if (optimal[j] && s2.charAt(j) == s3.charAt(j)) optimal[j + 1] = true;
	    }

	    for (int i = 0; i < s1.length(); i++) { //check select i-th char in s1
	        if (optimal[0] && s1.charAt(i) == s3.charAt(i)) optimal[0] = true;    //no char in s2 is selected
	        else optimal[0] = false;
	        for (int j = 0; j < s2.length(); j++) {  //select j-th char
	        	optimal[j + 1] = ((s1.charAt(i) == s3.charAt(i + j + 1) && optimal[j + 1]) ||
	                    s2.charAt(j) == s3.charAt(i + j + 1) && optimal[j]);
	        }
	    }
	    return optimal[s2.length()];
    }

}
