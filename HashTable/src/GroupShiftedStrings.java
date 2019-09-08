import java.util.*;
import java.util.HashMap;

/**
 * Created by thanksgiving on 1/8/16.
 */
public class GroupShiftedStrings {
    public static void main(String args[]) {
        GroupShiftedStrings obj = new GroupShiftedStrings();
        String[] test = {"fpbnsbrkbcyzdmmmoisaa",
                "cpjtwqcdwbldwwrryuclcngw",
                "a",
                "fnuqwejouqzrif",
                "js",
                "qcpr",
                "zghmdiaqmfelr",
                "iedda",
                "l",
                "dgwlvcyubde",
                "lpt",
                "qzq",
                "zkddvitlk",
                "xbogegswmad",
                "mkndeyrh",
                "llofdjckor",
                "lebzshcb",
                "firomjjlidqpsdeqyn",
                "dclpiqbypjpfafukqmjnjg",
                "lbpabjpcmkyivbtgdwhzlxa",
                "wmalmuanxvjtgmerohskwil",
                "yxgkdlwtkekavapflheieb",
                "oraxvssurmzybmnzhw",
                "ohecvkfe",
                "kknecibjnq",
                "wuxnoibr",
                "gkxpnpbfvjm",
                "lwpphufxw",
                "sbs",
                "txb",
                "ilbqahdzgij",
                "i",
                "zvuur",
                "yfglchzpledkq",
                "eqdf",
                "nw",
                "aiplrzejplumda",
                "d",
                "huoybvhibgqibbwwdzhqhslb",
                "rbnzendwnoklpyyyauemm"};
        System.out.println(obj.groupStrings(test));
    }

    /**
     * 将所有string归一化为a开头的string，以该string为key来存list
     */
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strings) {
            List<String> list;
            if (!map.containsKey(shift(s))) {
                list = new ArrayList<>();
            } else {
                list = map.get(shift(s));
            }
            list.add(s);
            map.put(shift(s), list);
        }

        for (String key : map.keySet()) {
            List<String> sub = map.get(key);
            Collections.sort(sub);
            res.add(sub);
        }
        return res;
    }

    private String shift(String s) {
        if (s.startsWith("a")) {
            return s;
        }

        int n = s.charAt(0) - 'a';
        char[] num = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            num[i] = (char) (((s.charAt(i) - 'a' + (26 - n)) % 26) + 'a');
        }
        return new String(num);
    }
   /* public List<List<String>> groupStrings(String[] strings) {
        HashMap<String, List<String>> map = new HashMap<>();
        List<List<String>> res = new ArrayList<>();
        Outer:

        for (int i = 0; i < strings.length; i++) {
            for (String key : map.keySet()) {
                if (match(key, strings[i])) {
                    List<String> exist = map.get(key);
                    exist.add(strings[i]);
                    map.put(key, new ArrayList<>(exist));
                    continue Outer;
                }
            }
            List<String> part = new ArrayList<>();
            part.add(strings[i]);
            map.put(strings[i], part);
        }

        for (String key : map.keySet()) {
            List<String> unSorted = map.get(key);
            Collections.sort(unSorted);
            res.add(unSorted);
        }
        return res;
    }

    private boolean match(String a, String b) {
        if (a.length() != b.length()) return false;
        int distance;
        if (a.charAt(0) < b.charAt(0)) {
            distance = b.charAt(0) - a.charAt(0);
        } else {
            distance = b.charAt(0) + 26 - a.charAt(0);
        }
        for (int i = 1; i < a.length(); i++) {
            if (a.charAt(i) + distance >= 123) {
                if (a.charAt(i) + distance - 26 != b.charAt(i))
                    return false;
            } else {
                if (a.charAt(i) + distance != b.charAt(i))
                    return false;
            }
        }
        return true;
    }*/
}
