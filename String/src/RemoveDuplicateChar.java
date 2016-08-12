import java.util.*;

/**
 * Created by thanksgiving on 2/27/16.
 */
public class RemoveDuplicateChar {
    public static void main(String[] args) {
        RemoveDuplicateChar obj = new RemoveDuplicateChar();
        System.out.println(obj.removeDuplicateLetters("bcabc"));
        System.out.println(obj.removeDuplicateLetters("aabaa"));
        System.out.println(obj.removeDuplicateLetters("cbacdcbc"));
    }

    /**
     * remove duplicate letters and keep the first occurrence
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

    public String removeDuplicateLetters(String s) {
        int[] res = new int[26]; //will contain number of occurences of character (i+'a')
        boolean[] visited = new boolean[26]; //will contain if character (i+'a') is present in current result Stack
        char[] a = s.toCharArray();
        for (char c : a) res[c - 'a']++;

        Stack<Character> stack = new Stack<>(); // answer stack
        int i;
        for (char c : a) {
            i = c - 'a';
            res[i]--;   //decrement number of characters remaining in the string to be analysed
            if (visited[i]) //if character is already present in stack, dont bother
                continue;
            //if current character is smaller than last character in stack which occurs later in the string again
            //it can be removed and  added later e.g stack = bc remaining string abc then a can pop b and then c
            while (!stack.isEmpty() && c < stack.peek() && res[stack.peek() - 'a'] != 0) {
                visited[stack.pop() - 'a'] = false;
            }
            stack.push(c); //add current character and mark it as visited
            visited[i] = true;
        }

        StringBuilder sb = new StringBuilder();
        //pop character from stack and build answer string from back
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }
        return sb.toString();





        /*        char[] a = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        Stack<Character> stack = new Stack<>();
        boolean needMove = false;
        for (int i = 0; i < a.length; i++) {
            if (!map.containsKey(a[i])) {
                map.put(a[i], 1);
                stack.add(a[i]);
            } else {
                Character last = stack.pop();
                String temp = String.valueOf(last);
                while (last != a[i]) {
                    if (a[i] - last > 0) needMove = true;
                    last = stack.pop();
                    temp = last + temp;
                }
                if (temp.compareTo(temp.substring(1) + a[i]) > 0) {
                    temp = temp.substring(1) + a[i];
                }
                System.out.println("temp " + temp);
                for (char c : temp.toCharArray()) {
                    stack.add(c);
                }
                needMove = false;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char c : stack) {
            sb.append(c);
        }
        return sb.toString();*/
    }
}
