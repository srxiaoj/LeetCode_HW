import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by thanksgiving on 9/9/16.
 */
public class RoyalName {
    public static void main(String[] args) {
        String[] names = {"Louis IX", "Louis VIII", "Alex X"};
        String[] res = getSortedList(names);
        printArray(res);
    }

    static class Person {
        String name;
        int num;

        public Person(String name, int num) {
            this.name = name;
            this.num = num;
        }
    }

    public static String[] getSortedList(String[] names) {
        if (names.length < 2) return names;
        Map<Person, String> map = new HashMap<>();
        String[] res = new String[names.length];

        Person[] persons = new Person[names.length];
        for (int i = 0; i < persons.length; i++) {
            String[] name = names[i].split(" ");
            int num = romanToInt(name[1]);
            Person person = new Person(name[0], num);
            persons[i] = person;
            map.put(person, names[i]);
        }

        Arrays.sort(persons, new MyComparator());
        for (int i = 0; i < persons.length; i++) {
            res[i] = map.get(persons[i]);
        }
        return res;
    }

    static class MyComparator implements Comparator<Person> {
        @Override
        public int compare(Person p1, Person p2) {
            if (p1.name.compareTo(p2.name) == 0) {
                return p1.num - p2.num;
            } else {
                return p1.name.compareTo(p2.name);
            }
        }
    }

    public static int romanToInt(String s) {
        Map<String, Integer> map = new HashMap<>();
        map.put("L", 50);
        map.put("XL", 40);
        map.put("X", 10);
        map.put("IX", 9);
        map.put("V", 5);
        map.put("IV", 4);
        map.put("I", 1);

        int res = 0;
        if (map.containsKey(s)) {
            return map.get(s);
        }
        int i = 0;
        // i go to s.length() - 2 to make sure not out of boundary
        while (i < s.length() - 1) {
            String sub = s.substring(i, i + 2);
            if (map.containsKey(sub)) {
                res += map.get(sub);
                i += 2;
            } else {
                res += map.get(s.substring(i, i + 1));
                i++;
            }
        }
        // handle last character
        if (i < s.length()) {
            res += map.get(s.substring(i, i + 1));
        }
        return res;
    }

    //print array
    public static void printArray(String[] A) {
        System.out.print("[");
        for (int i = 0; i < A.length; i++) {
            if (i != A.length - 1)
                System.out.print(A[i] + ", ");
            else
                System.out.print(A[i]);
        }
        System.out.println("]");
    }
}
