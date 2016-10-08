import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * Created by Administrator on 2016/10/7.
 */
public class KClosestPoints {
    // SOL 1
    public static CPoint[] findClose1(CPoint[] arr, int k) {
        if (k == 0) {
            return new CPoint[0];
        }
        // construct a min heap to store and sort incoming dis
        // initial size also can be arr.length
        PriorityQueue<CPoint> minHeap = new PriorityQueue<CPoint>(k, new Comparator<CPoint>() {
            @Override
            public int compare(CPoint a, CPoint b) {
                double disa = a.x * a.x + a.y * a.y;
                double disb = b.x * b.x + b.y * b.y;
                if (disb > disa) {
                    return -1;
                } else if (disb < disa) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });
        for (CPoint p : arr) {
            minHeap.offer(p);
        }
        // return the k closest points
        CPoint[] rst = new CPoint[k];
        for (int i = 0; i < k; i++) {
            rst[i] = minHeap.poll();
        }
        return rst;
    }

    // SOL 1’
    public static CPoint[] findClose32(CPoint[] arr, int k) {
        if (k == 0) {
            return new CPoint[0];
        }
        Comparator<CPoint> cmp = new Comparator<CPoint>() {
            public int compare(CPoint o1, CPoint o2) {
                double d1 = o1.x * o1.x + o1.y * o1.y;
                double d2 = o2.x * o2.x + o2.y * o2.y;
                if (d1 > d2) {
                    return 1;
                } else if (d1 == d2) {
                    return 0;
                } else {
                    return -1;
                }
            }
        };
        PriorityQueue<CPoint> minHeap = new PriorityQueue(k, cmp);
        for (CPoint p : arr) {
            minHeap.offer(p);
        }
        CPoint[] rst = new CPoint[k];
        for (int i = 0; i < k; i++) {
            rst[i] = minHeap.poll();
        }
        return rst;
    }

    // SOL 2
    public static CPoint[] findClose2(CPoint[] arr, int k) {
        if (k == 0) {
            return new CPoint[0];
        }
        CPoint[] rst = new CPoint[k];
        DPoint[] sort = new DPoint[arr.length];
        for (int i = 0; i < arr.length; i++) {
            sort[i] = new DPoint(arr[i]);
        }
        Arrays.sort(sort);
        for (int i = 0; i < k; i++) {
            rst[i] = sort[i].node;
        }
        return rst;
    }

    public static class DPoint implements Comparable<DPoint> {
        double distance;
        CPoint node;

        DPoint(CPoint m) {
            distance = m.x * m.x + m.y * m.y;
            node = m;
        }

        @Override
        public int compareTo(DPoint o) {
            if (this.distance > o.distance) {
                return 1;
            } else if (this.distance < o.distance) {
                return -1;
            } else {
                return 0;
            }
        }
    }

    // SOL 3
    public static CPoint[] findClose3(CPoint[] arr, int k) {
        if (arr == null || arr.length == 0 || k == 0) {
            return new CPoint[0];
        }
        double[] dis = new double[arr.length];
        for (int i = 0; i < arr.length; i++) {
            dis[i] = arr[i].x * arr[i].x + arr[i].y * arr[i].y;
        }
        HashMap<Double, CPoint> map = new HashMap<Double,
                CPoint>();
        for (int i = 0; i < arr.length; i++) {
            map.put(dis[i], arr[i]);
        }
        CPoint[] rst = new CPoint[k];
        Arrays.sort(dis);
        for (int i = 0; i < k; i++) {
            if (map.containsKey(dis[i])) {
                rst[i] = map.get(dis[i]);
            }
        }
        return rst;
    }

    public static class CPoint {
        double x;
        double y;

        public CPoint(double a, double b) {
            x = a;
            y = b;
        }
    }
}
