import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * Created by thanksgiving on 2/27/16.
 */
public class RemoveDuplicateChar {
    public static void main(String[] args) {
        RemoveDuplicateChar obj = new RemoveDuplicateChar();
        String s1 = "bcabc";
        String s2 = "aabaa";

        System.out.println(obj.removeDuplicate(s1));
        System.out.println(obj.removeDuplicate(s2));
    }

    /**
     * remove duplicate letters and keep the first occurrence
     *
     * @param s
     * @return
     */
    public String removeDuplicate(String s) {
        Set<Character> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!set.contains(s.charAt(i))) {
                set.add(s.charAt(i));
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }

    public String removeDuplicateLetters(String sr) {

        int[] res = new int[26]; //will contain number of occurences of character (i+'a')
        boolean[] visited = new boolean[26]; //will contain if character (i+'a') is present in current result Stack
        char[] ch = sr.toCharArray();
        for (char c : ch) {  //count number of occurences of character
            res[c - 'a']++;
        }
        Stack<Character> st = new Stack<>(); // answer stack
        int index;
        for (char s : ch) {
            index = s - 'a';
            res[index]--;   //decrement number of characters remaining in the string to be analysed
            if (visited[index]) //if character is already present in stack, dont bother
                continue;
            //if current character is smaller than last character in stack which occurs later in the string again
            //it can be removed and  added later e.g stack = bc remaining string abc then a can pop b and then c
            while (!st.isEmpty() && s < st.peek() && res[st.peek() - 'a'] != 0) {
                visited[st.pop() - 'a'] = false;
            }
            st.push(s); //add current character and mark it as visited
            visited[index] = true;
        }

        StringBuilder sb = new StringBuilder();
        //pop character from stack and build answer string from back
        while (!st.isEmpty()) {
            sb.insert(0, st.pop());
        }
        return sb.toString();
    }
}
