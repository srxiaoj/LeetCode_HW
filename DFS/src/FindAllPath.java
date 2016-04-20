import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

/**
 * Created by thanksgiving on 4/19/16.
 */
public class FindAllPath {
    public static void main(String[] args) {
        String file = "/home/thanksgiving/leetCodeWorkSpace/DFS/FindAllPath";
        FindAllPath obj = new FindAllPath();
        List<List<String>> res = obj.getPath(file);
        System.out.println(res);
    }

    public List<List<String>> getPath(String file) {
        // parse file, generate {key -> (B, C, D)} map
        BufferedReader br = null;
        String line = null;
        Map<String, String[]>map = new HashMap<>();
        String start = null;
        String end = null;
        try {
            br = new BufferedReader(new FileReader(file));
            line = br.readLine();
            start = line.split("\\s+")[0];
            end = line.split("\\s+")[1];

            while ((line = br.readLine()) != null) {
                String[] fields = line.split(":");
                String head = fields[0].trim();
                String tail = fields[1].trim();
                String[] tailArray = tail.split(" ");
                map.put(head, tailArray);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        List<List<String>> res = new ArrayList<>();
        List<String> part = new ArrayList<>();
        part.add(start);
        helper(res, part, start, end, map);
        return res;
    }

    public void helper(List<List<String>> res, List<String> part, String lastWord, String end, Map<String, String[]> map) {
        String[] nextList = map.get(lastWord);
        for (String s : nextList) {
            List<String> newList = new ArrayList<>(part);
            newList.add(s);
            if (s.equals(end)) {
                res.add(newList);
            } else {
                helper(res, newList, s, end, map);
            }
        }
    }
}
