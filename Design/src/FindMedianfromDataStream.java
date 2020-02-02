import java.util.Collections;
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

  private PriorityQueue<Double> maxHeap;
  private PriorityQueue<Double> minHeap;

  public FindMedianfromDataStream() {
    // minHeap = new PriorityQueue<Double>(new MaxComparator());
    minHeap = new PriorityQueue<Double>();
    maxHeap = new PriorityQueue<>(Collections.reverseOrder());
  }

  // Adds a number into the data structure.
  public void addNum(int num) {
    minHeap.offer((double) num);
    maxHeap.offer(minHeap.poll());
    if (maxHeap.size() > minHeap.size()) {
      minHeap.offer(maxHeap.poll());
    }
    System.out.println("minHeap is " + minHeap);
    System.out.println("maxHeap is " + maxHeap);
  }

  // Returns the median of current data stream
  public double findMedian() {
    if (minHeap.size() == maxHeap.size()) {
      return (minHeap.peek() + maxHeap.peek()) / 2.0;
    } else {
      return minHeap.peek();
    }
  }
}
