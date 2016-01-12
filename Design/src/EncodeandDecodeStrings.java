import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by thanksgiving on 1/10/16.
 */
public class EncodeandDecodeStrings {
    public static void main(String[] args) {
        // Your Codec object will be instantiated and called as such:
        List<String> strs = new ArrayList<>(Arrays.asList("", ""));
        Codec codec = new Codec();

        System.out.println(codec.decode(codec.encode(strs)));
    }
}

class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(s.length()).append(",").append(s);
        }
        System.out.println(sb);
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> res = new ArrayList<String>();
        int i = 0;
        while (i < s.length()) {
            // need to start search after i
            int dot = s.indexOf(",", i);
            String st = s.substring(i, dot);
            int len = Integer.parseInt(st);
            res.add(s.substring(dot + 1, dot + len + 1));
            i = 1 + dot + len;
        }
        return res;
    }
}
