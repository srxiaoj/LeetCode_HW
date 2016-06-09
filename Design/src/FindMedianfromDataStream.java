import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by thanksgiving on 6/9/16.
 */
public class FindMedianfromDataStream {
    public static void main(String[] args) {
        FindMedianfromDataStream obj = new FindMedianfromDataStream();
        obj.addNum(3);
        obj.addNum(2);
        System.out.println(obj.findMedian());
        obj.addNum(1);
        System.out.println(obj.findMedian());
        obj.addNum(4);
        System.out.println(obj.findMedian());
    }

    class MaxComparator implements Comparator<Double> {
        public int compare(Double a, Double b) {
            return (int) (b - a);
        }
    }
    private PriorityQueue<Double> minHeap;
    private PriorityQueue<Double> maxHeap;
    public FindMedianfromDataStream() {
        minHeap = new PriorityQueue<Double>(new MaxComparator());
        maxHeap = new PriorityQueue<Double>();
//        maxheap = new PriorityQueue<>(Collections.reverseOrder());
    }
    // Adds a number into the data structure.
    public void addNum(int num) {
        maxHeap.offer((double) num);
        minHeap.offer(maxHeap.poll());
        if (minHeap.size() > maxHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }

    // Returns the median of current data stream
    public double findMedian() {
        if (maxHeap.size() == minHeap.size()) {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        } else {
            return maxHeap.peek();
        }
    }
}
