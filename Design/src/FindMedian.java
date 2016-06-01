import java.util.Collections;
import java.util.PriorityQueue;

public class FindMedian {
    PriorityQueue<Integer> minheap;
    PriorityQueue<Integer> maxheap;
    public FindMedian() {
        minheap = new PriorityQueue<>();
        maxheap = new PriorityQueue<>(Collections.reverseOrder());
    }

    private void add(int num) {
        minheap.add(num);
        maxheap.add(minheap.poll());
        if (minheap.size() < maxheap.size()) {
            minheap.add(maxheap.poll());
        }
    }

    private double getMedian() {
        if (maxheap.size() == 0 || minheap.size() > maxheap.size()) {
            return minheap.peek();
        } else {
            int t1 = minheap.peek();
            int t2 = maxheap.peek();
            return (double) (t1 + t2) / 2.0;
        }
    }

    public static void main(String[] args) {
        FindMedian obj = new FindMedian();
        obj.add(3);
        obj.add(2);
        System.out.println(obj.getMedian());
        obj.add(1);
        System.out.println(obj.getMedian());
        obj.add(4);
        System.out.println(obj.getMedian());
    }
}
