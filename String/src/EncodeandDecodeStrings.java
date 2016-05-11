import java.util.ArrayList;
import java.util.List;

/**
 * Created by thanksgiving on 5/10/16.
 */
public class EncodeandDecodeStrings {
    public static void main(String[] args) {
        EncodeandDecodeStrings obj = new EncodeandDecodeStrings();
        List<String> strs = new ArrayList<>();
        strs.add("aa2/bb");
        strs.add("asf");
        System.out.println(obj.encode(strs));
        System.out.println(obj.decode(obj.encode(strs)));
    }

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        int n = strs.size();
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(s.length()).append("/").append(s);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> res = new ArrayList<>();
        int i = 0;
        while (i < s.length()) {
            int slash = s.indexOf("/", i);
            int size = Integer.parseInt(s.substring(i, slash));
            res.add(s.substring(slash + 1, slash + size + 1));
            i = slash + size + 1;
        }
        return res;
    }
}
