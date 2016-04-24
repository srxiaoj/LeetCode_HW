import java.util.ArrayList;
import java.util.List;

/**
 * Created by thanksgiving on 4/23/16.
 */
public class FlipGameII {
    public static void main(String[] args) {
        FlipGameII obj = new FlipGameII();
//        String s = "+++++++++";
        String s = "++++";
        System.out.println(obj.canWin(s));
    }

    public boolean canWin(String s) {
        if (s == null) return false;
        List<String> res = new ArrayList<>();
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.startsWith("++", i)) {
                String temp = s.substring(0, i) + "--" + s.substring(i + 2);
                if (!canWin(temp)) {
                    return true;
                }
            }
        }
        return false;
    }
}
