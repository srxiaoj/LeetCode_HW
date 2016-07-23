import java.util.*;

/**
 * Created by thanksgiving on 7/22/16.
 */
public class Person {
    List<Person> friend;
    String name;

    public Person(String name) {
        this.name = name;
        this.friend = new ArrayList<>();
    }

    public boolean equals(Person a, Person b) {
        return a.name.equals(b.name);
    }

    public String toString() {
        return name;
    }

    public static List<Person> getAllFriend(Person p) {
        Set<Person> set = new HashSet<>();
        List<Person> res = new ArrayList<>();
        dfs(set, p, res, p);
        return res;
    }

    private static void dfs(Set<Person> set, Person p, List<Person> res, Person next) {
        if (set.contains(next)) return;
        if (!next.equals(p)) {
            res.add(next);
            set.add(next);
        }

        List<Person> nextList = next.friend;
        for (Person newP : nextList) {
            dfs(set, p, res, newP);
        }
    }

    public static List<Person> getAllFriendBfs(Person p) {
        Set<Person> set = new HashSet<>();
        List<Person> res = new ArrayList<>();
        Queue<Person> queue = new LinkedList<>();
        queue.offer(p);
        while (!queue.isEmpty()) {
            Person next = queue.poll();
            List<Person> nextList = next.friend;
            for (Person newP : nextList) {
                if (!set.contains(newP) && !newP.equals(p)) {
                    set.add(newP);
                    res.add(newP);
                    queue.offer(newP);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Person A = new Person("A");
        Person B = new Person("B");
        Person C = new Person("C");
        Person D = new Person("D");
        Person E = new Person("E");
        Person F = new Person("F");
        Person G = new Person("G");

        A.friend = new ArrayList(Arrays.asList(B, C, D));
        B.friend = new ArrayList(Arrays.asList(C, E, F, G));
        C.friend = new ArrayList(Arrays.asList(G));
        D.friend = new ArrayList(Arrays.asList(F, G));
        System.out.println(getAllFriend(A));
        System.out.println(getAllFriend(B));
        System.out.println(getAllFriendBfs(A));
        System.out.println(getAllFriendBfs(B));
    }
}
