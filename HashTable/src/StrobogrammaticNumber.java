import java.util.HashMap;

/**
 * Created by thanksgiving on 1/6/16.
 */
public class StrobogrammaticNumber {
    public static void main(String[] args) {
        StrobogrammaticNumber obj = new StrobogrammaticNumber();
        String s1 = "2";
        System.out.println(obj.isStrobogrammatic(s1));
    }
    public boolean isStrobogrammatic(String num) {
        HashMap<Character, Character> map = new HashMap<>();
        map.put('0', '0');
        map.put('1', '1');
        map.put('6', '9');
        map.put('9', '6');
        map.put('8', '8');
        int i = 0, j = num.length() - 1;
        while (i <= j) {
            if (!map.containsKey(num.charAt(i))) {
                return false;
            }
            if (map.get(num.charAt(i)) != num.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
