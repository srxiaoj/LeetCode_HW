import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Created by thanksgiving on 4/19/16.
 */
public class FindAllPath {
    public static void main(String[] args) {
        String file = "/home/thanksgiving/leetCodeWorkSpace/DFS/FindAllPath";
        FindAllPath obj = new FindAllPath();
        List<String> res = obj.getPath(file);
        System.out.println(res);
    }

    public List<String> getPath(String file) {
        // parse file, generate {key -> (B, C, D)} map
//        BufferedReader br = null;
//        String line = null;
//        Map<String, String[]>map = new HashMap<>();
//        String start = null;
//        String end = null;
//        try {
//            br = new BufferedReader(new FileReader(file));
//            line = br.readLine();
//            start = line.split("\\s+")[0];
//            end = line.split("\\s+")[1];
//
//            while ((line = br.readLine()) != null) {
//                String[] fields = line.split(":");
//                String head = fields[0].trim();
//                String tail = fields[1].trim();
//                String[] tailArray = tail.split(" ");
//                map.put(head, tailArray);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        // get input from scanner
        Scanner sc = null;
        try {
            sc = new Scanner(new File(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String line = sc.nextLine();
        String start = line.split("\\s+")[0];
        String end = line.split("\\s+")[1];

        Map<String, String[]>map = new HashMap<>();
        while (sc.hasNextLine()) {
            line = sc.nextLine();
            String[] fields = line.split(":");
            String head = fields[0].trim();
            String tail = fields[1].trim();
            String[] tailArray = tail.split(" ");
            map.put(head, tailArray);
        }

        List<String> res = new ArrayList<>();
        StringBuilder part = new StringBuilder(start);
        helper(res, part, start, end, map);
        return res;
    }

    public void helper(List<String> res, StringBuilder part, String lastWord, String end, Map<String, String[]> map) {
        String[] nextList = map.get(lastWord);
        for (String s : nextList) {
            // avoid cycle in graph
            if (!part.toString().contains(s)) {
                StringBuilder newSB = new StringBuilder(part);
                newSB.append(s);
                if (s.equals(end)) {
                    res.add(newSB.toString());
                } else {
                    helper(res, newSB, s, end, map);
                }
            }
        }
    }
}
