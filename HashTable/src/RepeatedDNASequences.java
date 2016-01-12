import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by thanksgiving on 1/3/16.
 */
public class RepeatedDNASequences {
    public static void main(String[] args) {
        RepeatedDNASequences obj = new RepeatedDNASequences();
        String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        System.out.println(obj.findRepeatedDnaSequences(s));

    }
    public List<String> findRepeatedDnaSequences(String s) {
        Set seen = new HashSet();
        Set repeated = new HashSet();
        for (int i = 0; i + 9 < s.length(); i++) {
            String ten = s.substring(i, i + 10);
            if (!seen.add(ten))
                repeated.add(ten);
        }
        return new ArrayList(repeated);
    }
}
