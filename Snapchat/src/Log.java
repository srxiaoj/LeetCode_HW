import java.util.*;

/**
 * Created by thanksgiving on 8/22/16.
 */
public class Log {
    public static void main(String[] args) {
        Log log = new Log();
        Entry[] entries;
        Entry e1 = new Entry("f1", true, 1);
        Entry e2 = new Entry("f2", true, 2);
        Entry e3 = new Entry("f2", false, 3);
        Entry e4 = new Entry("f3", true, 4);
        Entry e5 = new Entry("f3", false, 5);
        Entry e6 = new Entry("f1", false, 6);
        entries = new Entry[]{e1, e2, e3, e4, e5, e6};
        log.getLog(entries);


        Entry a1 = new Entry("f1", true, 1);
        Entry a2 = new Entry("f1", true, 2);
        Entry a3 = new Entry("f2", true, 4);
        Entry a4 = new Entry("f2", false, 8);
        Entry a5 = new Entry("f1", false, 16);
        Entry a6 = new Entry("f1", false, 32);
        Entry a7 = new Entry("f3", true, 64);
        Entry a8 = new Entry("f3", false, 128);
        Entry[] entries1 = new Entry[]{a1, a2, a3, a4, a5, a6, a7, a8};

        log.getLog(entries1);
    }

    public void getLog(Entry[] entries) {
        Map<String, List<Interval>> map = new HashMap<>();
        Stack<Entry> stack = new Stack<>();
        for (int i = 0; i < entries.length; i++) {
            if (stack.isEmpty()) {
                if (entries[i].start) {
                    stack.push(entries[i]);
                } else {
                    List<Interval> list = map.get(entries[i].func);
                    list.get(list.size() - 1).end = entries[i].timestamp;
                }
                continue;
            }
            Entry last = stack.peek();
            if (!entries[i].func.equals(last.func)) {
                List<Interval> list;
                if (!map.containsKey(last.func)) {
                    list = new ArrayList<>();
                } else {
                    list = map.get(last.func);
                }
                Interval interval = new Interval(last.timestamp, entries[i].timestamp);
                list.add(interval);
                map.put(last.func, list);
                stack.push(entries[i]);
            }
            if (entries[i].func.equals(last.func) && !entries[i].start) {
                stack.pop();
                List<Interval> list;
                if (!map.containsKey(last.func)) {
                    list = new ArrayList<>();
                } else {
                    list = map.get(last.func);
                }
                Interval interval = new Interval(last.timestamp, entries[i].timestamp);
                list.add(interval);
                map.put(last.func, list);
                if (!stack.isEmpty())
                    stack.peek().timestamp = entries[i].timestamp;
            }


        }
        for (String key : map.keySet()) {
            System.out.println(key + "->" + map.get(key));
        }
    }

    private static class Entry {
        String func;
        boolean start;
        int timestamp;

        public Entry(String func, boolean start, int timestamp) {
            this.func = func;
            this.start = start;
            this.timestamp = timestamp;
        }
    }

    private class Interval {
        int start;
        int end;

        public Interval(int s, int e) {
            this.start = s;
            this.end = e;
        }

        public String toString() {
            return "[" + start + "," + end + "]";
        }
    }
}
