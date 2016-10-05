/**
 * Created by thanksgiving on 10/4/16.
 */
public class ArrayToQueue {
    public static void main(String[] args) {
        MyQueue queue = new MyQueue(4);
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        queue.offer(5);
        System.out.println(queue.poll());
        queue.offer(6);
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());

    }

    static class MyQueue {
        int[] num;
        int tail;
        int head;
        int size;

        public MyQueue(int n) {
            this.num = new int[n];
            this.tail = 0;
            this.head = 0;
        }

        public void offer(int x) {
            int n = num.length;
            if (size >= n) {
                poll();
            }
            num[tail] = x;
            tail = (tail + 1) % n;
            size = (tail + n - head) % n;
            if (size == 0) size = n;
        }

        public int poll() {
            if (size <= 0) return -1;
            int n = num.length;
            int temp = num[head];
            head = (head + 1) % n;
            return temp;
        }
    }

    //print array
    public static void printArray(int[] A) {
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
