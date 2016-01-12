import java.util.ArrayDeque;
import java.util.Deque;


public class LongestValidParentheses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = new String("())((())");
		System.out.println(longestValidParentheses(s));
	}
	public static int longestValidParentheses(String s) {
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
