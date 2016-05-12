import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
    public static void main(String[] args) {
        String[] test = {"eat", "tea", "tan", "ate", "nat", "bat"};
        String[] test2 = {"cab", "tin", "pew", "duh", "may", "ill", "buy", "bar", "max", "doc"};
        GroupAnagrams obj = new GroupAnagrams();
        List<List<String>> res = obj.groupAnagrams(test);
        printTwoDArrayList(res);
        List<List<String>> res2 = obj.groupAnagrams(test2);
        printTwoDArrayList(res2);
    }

    /**
     * 存map时 key用某组anagram sort之后的string作为key
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new LinkedList<>();
        List<String> list;
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            list = new LinkedList<>();
            String temp = sortString(strs[i]);
            if (!map.containsKey(temp)) {
                list.add(strs[i]);
                map.put(temp, list);
            } else {
                list = map.get(temp);
                // insert str[i] into correct sequence
                if (strs[i].compareTo(list.get(list.size() - 1)) >= 0) {
                    list.add(strs[i]);
                } else {
                    for (int k = 0; k < list.size(); k++) {
                        if (strs[i].compareTo(list.get(k)) < 0) {
                            list.add(k, strs[i]);
                            break;
                        }
                    }
                }
            }
        }
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            res.add(entry.getValue());
        }
        return res;
    }

    private String sortString(String test) {
        char[] ar = test.toCharArray();
        Arrays.sort(ar);
        String sorted = String.valueOf(ar);
        return sorted;
    }

    //print two dimensional array list, which can also be replaced by simply System.out.println(A)
    public static void printTwoDArrayList(List<List<String>> A) {
        for (int i = 0; i < A.size(); i++) {
            System.out.print(A.get(i) + " ");
            System.out.println("");
        }

    }
}
