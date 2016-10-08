import java.util.Arrays;

/**
 * Created by Administrator on 2016/10/7.
 */
public class FindTheOptimalWeights {
    public static void main(String[] args) {
        ContainerWeights res = findOptimalWeights(3.5, new double[] {1.0, 2.0, 3.0, 2.1, 3.3, 1.4});
        System.out.println(res.first + " " + res.second);
    }

    public static ContainerWeights findOptimalWeights(double capacity, double[] weights) {
        ContainerWeights con = new ContainerWeights();
        if (weights != null && weights.length >= 2) {
            Arrays.sort(weights);
            int l = 0, r = weights.length - 1;
            double lowerBound = 0;
            double sum = 0;

            while (l < r) {
                sum = weights[l] + weights[r];
                if (sum >= lowerBound && sum <= capacity) {
                    con.first = weights[l];
                    con.second = weights[r];
                    lowerBound = sum;
                }

                if (sum < capacity) {
                    l++;
                } else if (sum > capacity) {
                    r--;
                } else {
                    break;
                }
            }
        } else {
            throw new IllegalArgumentException();
        }
        return con;
    }

    static class ContainerWeights {
        public double first;
        public double second;
    }
}
