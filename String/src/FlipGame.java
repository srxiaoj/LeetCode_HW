import java.util.ArrayList;
import java.util.List;

/**
 * Created by thanksgiving on 1/10/16.
 */
public class FlipGame {
    public static void main(String[] args) {
        FlipGame obj = new FlipGame();
        String s = "+--+++--++";
//        System.out.println(s.replace("++", "--"));
        System.out.println(obj.generatePossibleNextMoves(s));
    }

    public List<String> generatePossibleNextMoves(String s) {
        List<String> list = new ArrayList();
        for (int i = -1; (i = s.indexOf("++", i + 1)) >= 0; )
            list.add(s.substring(0, i) + "--" + s.substring(i + 2));
        return list;
    }
}
