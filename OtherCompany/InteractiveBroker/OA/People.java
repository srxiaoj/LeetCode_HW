import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by thanksgiving on 9/8/16.
 */
public class People implements Comparable<People> {
    String m_firstName;
    String m_LastName;
    public People(String m_firstName, String m_LastName) {
        this.m_firstName = m_firstName;
        this.m_LastName = m_LastName;
    }
    public String toString() {
        return this.m_firstName + " " + this.m_LastName;
    }

    public static void main(String[] args) {
        People p1 = new People("Aohn", "Nas");
        People p2 = new People("John", "Abe");
        People p3 = new People("Jack", "Abe");
        People p4 = new People("France", "Goo");
        List<People> list = new ArrayList<>();
        list.add(p1);
        list.add(p2);
        list.add(p3);
        list.add(p4);
        Collections.sort(list);
        System.out.println(list);
    }


    public int compareTo(People p) {
        return m_LastName.compareTo(p.m_LastName) + m_firstName.compareTo(p.m_firstName);
//        int rLast = m_LastName.compareTo(p.m_LastName);
//        return rLast == 0 ? m_firstName.compareTo(p.m_firstName) : rLast;
    }
}
