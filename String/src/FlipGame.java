import java.util.ArrayList;
import java.util.List;

/**
 * Created by thanksgiving on 1/10/16.
 */
public class FlipGame {
    public static void main(String[] args) {
        FlipGame obj = new FlipGame();
        String s = "++++";
//        String s = "+--+++--++";
//        System.out.println(s.replace("++", "--"));
        System.out.println(obj.generatePossibleNextMoves(s));
    }

    public List<String> generatePossibleNextMoves(String s) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.startsWith("++", i)) {
                String temp = s.substring(0, i) + "--" + s.substring(i + 2);
                res.add(temp);
            }
        }
        return res;
       /* int i = -1;
        while (i < s.length() && s.indexOf("++", i + 1) >= 0) {
            String tmp = s;
            i = tmp.indexOf("++", i + 1);
            tmp = tmp.substring(0, i) + "--" + tmp.substring(i + 2);
            res.add(tmp);
            // no requirement to flip "--"
        }
        return res;*/
    }
}
