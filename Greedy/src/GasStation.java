/**
 * Created by thanksgiving on 12/29/15.
 */
public class GasStation {
    public static void main(String[] args) {
        int[] gas = {3, 4, 5};
        int[] cost = {4, 3, 1};
        GasStation obj = new GasStation();
        System.out.println(obj.canCompleteCircuit(gas, cost));
    }
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sumGas = 0;
        int sumCost = 0;
        int start = 0;
        int tank = 0;
        for (int i = 0; i < gas.length; i++) {
            sumGas += gas[i];
            sumCost += cost[i];
            tank += gas[i] - cost[i];
            if (tank < 0) {
                start = i + 1;
                tank = 0;
            }
        }
        if (sumCost > sumGas) {
            return -1;
        } else {
            return start;
        }
    }
}
