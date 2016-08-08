public class InterleavingString {

    public static void main(String[] args) {
//        System.out.println(isInterleave2("abbbbbbcabbacaacccababaabcccabcacbcaabbbacccaaaaaababbbacbb", "ccaacabbacaccacababbbbabbcacccacccccaabaababacbbacabbbbabc", "cacbabbacbbbabcbaacbbaccacaacaacccabababbbababcccbabcabbaccabcccacccaabbcbcaccccaaaaabaaaaababbbbacbbabacbbacabbbbabc"));
//        String s1 = "aabcc";
//        String s2 = "dbbca";
//        String s3 = "aadbbcbcac";
//        String s3 = "aadbbbaccc";
//        System.out.println(isInterleave(s1, s2, s3));
        System.out.println(isInterleave("bbc", "abc", "abcbcb"));
    }

    public static boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;
        int m = s1.length(), n = s2.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            // 注意是substring, 不是charAt
            if (s1.substring(0, i).equals(s3.substring(0, i))) {
                dp[i][0] = true;
            }
        }
        printArray(dp);
        for (int i = 0; i <= n; i++) {
            if (s2.substring(0, i).equals(s3.substring(0, i))) {
                dp[0][i] = true;
            }
        }
        printArray(dp);
        System.out.println("start loop");
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1))
                    dp[i][j] = true;
                if (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1))
                    dp[i][j] = true;
            }
            printArray(dp);
        }
        return dp[m][n];
      /*  if (s3.length() != s1.length() + s2.length()) return false;

        boolean[] dp = new boolean[s2.length() + 1];
        dp[0] = true;
        for (int j = 0; j < s2.length(); j++) { //check no s1 char is selected, if s2 could equals to s3
            if (dp[j] && s2.charAt(j) == s3.charAt(j)) dp[j + 1] = true;
        }
        printArray(dp);
        System.out.println("start loop");

        for (int i = 0; i < s1.length(); i++) { //check select i-th char in s1
            if (dp[0] && s1.charAt(i) == s3.charAt(i)) {
                dp[0] = true;    //no char in s2 is selected
            } else {
                dp[0] = false;
            }
            for (int j = 0; j < s2.length(); j++) {  //select j-th char
                dp[j + 1] = ((s1.charAt(i) == s3.charAt(i + j + 1) && dp[j + 1]) || s2.charAt(j) == s3.charAt(i + j + 1) && dp[j]);
            }
            printArray(dp);
        }
        return dp[s2.length()];*/
    }

    public static void printArray(boolean[] A) {
        System.out.print("[");
        for (int i = 0; i < A.length; i++) {
            if (i != A.length - 1)
                System.out.print(A[i] + ", ");
            else
                System.out.print(A[i]);
        }
        System.out.println("]");
    }

    /**
     * print 2D array.
     */
    public static void printArray(boolean[][] A) {
        for (int i = 0; i < A.length; i++) {
            System.out.print("[");
            for (int j = 0; j < A[i].length; j++) {
                if (j != A[i].length - 1) {
                    System.out.print(A[i][j] + ", ");
                } else
                    System.out.print(A[i][j]);

            }
            System.out.println("]");
        }
        System.out.println("");
    }

/*    public static boolean isInterleave2(String s1, String s2, String s3) {
        int m = s1.length(), n = s2.length(), len = s3.length();
		if (m + n != len) return false;
		List<Node>[] dp = new ArrayList[len + 1];
		dp[0] = new ArrayList<>();
		dp[0].add(new Node(0, 0));

		for (int k = 1; k <= len; k++) {
            if (dp[k - 1].size() == 0) return false;
            List<Node> last = dp[k - 1];
            dp[k] = new ArrayList<>();
            for (Node node : last) {
                if (node.i < m && s3.charAt(k - 1) == s1.charAt(node.i)) {
                    dp[k].add(new Node(node.i + 1, node.j));
                }
                if (node.j < n && s3.charAt(k - 1) == s2.charAt(node.j)) {
                    dp[k].add(new Node(node.i, node.j + 1));
                }
            }
        }
        if (dp[len].size() == 0) return false;
		return true;
	}

	static class Node {
		int i;
		int j;
		public Node(int a, int b) {
			i = a;
			j = b;
		}
	}*/
}
