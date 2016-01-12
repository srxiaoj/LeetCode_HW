import java.util.Stack;

import javax.xml.bind.ValidationEvent;

public class ValidPalindrome {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ValidPalindrome obj = new ValidPalindrome();
        String test = "A man, a plan, a canal: Panama";
        String test2 = "abba";
        System.out.println(obj.isPalindrome(test));
        System.out.println(obj.isPalindrome(test2));
        
    }
    public boolean isPalindrome(String s) {
        /*
        // Method 1: use stack
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < s.length(); i++){
            if (Character.isLetterOrDigit(s.charAt(i))) {
                sb.append(s.charAt(i));
            }
        }
        String res = sb.toString().toLowerCase();
        System.out.println(res.length());
        System.out.println(res.length() / 2);
        for (int i = 0; i < res.length() / 2; i++) {
            stack.add(res.charAt(i));
        }
        for (int i = (res.length() + 1) / 2; i < res.length(); i++) {
            if (stack.isEmpty() || stack.pop() != res.charAt(i)) {
                return false;
            }
        }
        return true;
        */
        
        // method 2: two pointers
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < s.length(); i++){
            if (Character.isLetterOrDigit(s.charAt(i))) {
                sb.append(s.charAt(i));
            }
        }
        String res = sb.toString().toLowerCase();
        int i = 0, j = res.length() - 1;
        while (i < j) {
//            System.out.println(res.charAt(i));
//            System.out.println(res.charAt(j));
            if (res.charAt(i) != res.charAt(j))
                return false;
            i++;
            j--;
            
        }
        return true;
    }
}
