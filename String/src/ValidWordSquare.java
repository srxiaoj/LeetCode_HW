import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2016/10/21.
 */
public class ValidWordSquare {
    public static void main(String[] args) {
        System.out.println(validWordSquare(new ArrayList<>(Arrays.asList("abc", "b", "c"))));
        System.out.println(validWordSquare(new ArrayList<>(Arrays.asList("abc","bde","cefg"))));
    }

    public static boolean validWordSquare(List<String> words) {
        if (words == null || words.size() == 0) return false;
        int col = words.get(0).length();
        int row = words.size();
        if (row != col) return false;
        StringBuilder[] sb = new StringBuilder[row];
        for (int i = 0; i < row; i++) {
            sb[i] = new StringBuilder();
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < words.get(i).length(); j++) {
                // 防止后面某行出现比总行数更长的单个单词
                if (j >= row) return false;
                sb[j].append(words.get(i).charAt(j));
            }
        }

        List<String> res = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            res.add(sb[i].toString());
        }
        return res.equals(words);
    }
}
