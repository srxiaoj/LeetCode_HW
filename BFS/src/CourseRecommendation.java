import java.util.*;

/**
 * Created by thanksgiving on 6/4/16.
 */
public class CourseRecommendation {
    public static void main(String[] args) {

    }

    public List<Integer> getRecommendation(User user) {
        Set<User> allUser = new HashSet<>();
        List<Integer> taken = getAttendedCourses(user);
        Set<Integer> takenSet = new HashSet<>();
        for (Integer oneCourse : taken) {
            takenSet.add(oneCourse);
        }
        List<User> oneLevel = getDirectFriend(user);
        for (int i = 0; i < oneLevel.size(); i++) {
            allUser.add(oneLevel.get(i));
        }

        for (int i = 0; i < oneLevel.size(); i++) {
            List<User> secondLevel = getDirectFriend(oneLevel.get(i));
            for (User second : secondLevel) {
                if (!user.equals(second))
                    allUser.add(second);
            }
        }

        Map<Integer, Integer> toTake = new HashMap();
        for (User sub : allUser) {
            List<Integer> courses = getAttendedCourses(sub);
            for (Integer course : courses) {
                if (!takenSet.contains(course)) {
                    if (!toTake.containsKey(course)) {
                        toTake.put(course, 1);
                    } else {
                        int count = toTake.get(course);
                        toTake.put(course, count + 1);
                    }
                }
            }
        }

        MyComparator com = new MyComparator(toTake);
        Map<Integer, Integer> sortCourse = new TreeMap<>(com);
        sortCourse.putAll(toTake);
        List<Integer> res = new ArrayList<>();
        for (Integer suggest : sortCourse.keySet()) {
            res.add(suggest);
        }
        return res;
    }

    public List<User> getDirectFriend(User user) {
        return new ArrayList<>();
    }

    public List<Integer> getAttendedCourses(User user) {
        return new ArrayList<>();
    }

    private class User {
        String name;
        public User(String a) {
            this.name = a;
        }
    }

    class MyComparator implements Comparator {
        Map map;
        public MyComparator(Map map) {
            this.map = map;
        }
        public int compare(Object o1, Object o2) {
            return ((Integer) map.get(o2)).compareTo((Integer) map.get(o1));
        }
    }
}
