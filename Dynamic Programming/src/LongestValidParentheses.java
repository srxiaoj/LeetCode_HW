import java.util.ArrayDeque;
import java.util.Deque;


public class LongestValidParentheses {

	public static void main(String[] args) {
		System.out.println(longestValidParentheses("())((())"));
        System.out.println(longestValidParentheses("(()())"));
        System.out.println(longestValidParentheses("()(())"));
	}

    /**
     * 解法类似 countMaxOneZeroPair
     */
    public static int longestValidParentheses(String s) {
        if (s == null || s.length() < 2) return 0;
        int n = s.length();
        int[] dp = new int[n + 1];
        int max = 0;
        for (int i = 1; i < n; i++) {
            if (isPair(s.charAt(i), s.charAt(i - 1))) {
                dp[i + 1] = dp[i - 1] + 2;
            } else if (dp[i] > 0) {
                if (i - dp[i] - 1 >= 0 && isPair(s.charAt(i), s.charAt(i - dp[i] - 1))) {
                    dp[i + 1] = dp[i] + 2;
                    if (dp[i - dp[i] - 1] > 0) {
                        dp[i + 1] += dp[i - dp[i] - 1];
                    }
                }
            }
            max = Math.max(dp[i + 1], max);
        }
        return max;
    }

    private static boolean isPair(char a, char b) {
        if (a == ')' && b == '(') {
            return true;
        }
        return false;
    }

	public static int longestValidParentheses2(String s) {
        //used to store the number of continuous () before current (, if a ( is followed right after the previous ), then the total number should be previousCount+currentCount
        Deque<Integer> stack = new ArrayDeque<>();
        
		int count = 0;
		int max = 0;
		int size = s.length();
		int i = 0;
		while(i < size){
			if(s.charAt(i) == '('){
			    stack.push(count);
				i++;
				count = 0;
			}
			else if(s.charAt(i) == ')' && stack.size() > 0){
				count+=stack.poll()+1;
				i++;
				max = Math.max(max, count);
			}
			else{// s.charAt(i) == ')' && numOfLeftBeforeRight == 0
				i++;
				count = 0;
				stack.clear();
			}
			
		}
		return max*2;
    }
}
