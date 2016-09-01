import java.util.Iterator;
import java.util.LinkedHashSet;

/**
 * Created by thanksgiving on 8/31/16.
 */
public class DesignPhoneDirectory {
    public static void main(String[] args) {
        PhoneDirectory obj = new PhoneDirectory(3);
        System.out.println(obj.get());
        System.out.println(obj.get());
        System.out.println(obj.check(2));
        System.out.println(obj.get());
        System.out.println(obj.check(2));
        obj.release(2);
        System.out.println(obj.check(2));
    }

    public static class PhoneDirectory {

        LinkedHashSet<Integer> lhs;
        int max;
        /** Initialize your data structure here
         @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
        public PhoneDirectory(int maxNumbers) {
            lhs = new LinkedHashSet<>();
            for (int i = 0; i < maxNumbers; i++) {
                lhs.add(i);
            }
            max = maxNumbers;
        }

        /** Provide a number which is not assigned to anyone.
         @return - Return an available number. Return -1 if none is available. */
        public int get() {
            Iterator<Integer> it = lhs.iterator();
            if (!it.hasNext()) return -1;
            int next = it.next();
            lhs.remove(next);
            return next;
        }

        /** Check if a number is available or not. */
        public boolean check(int number) {
            if (lhs.contains(number)) {
                return true;
            }
            return false;
        }

        /** Recycle or release a number. */
        public void release(int number) {
            lhs.add(number);
        }
    }
}
