/**
 * Created by thanksgiving on 12/29/15.
 */
public class GasStation {
    public static void main(String[] args) {
        int[] gas = {2, 1, 4};
        int[] cost = {5, 3, 1};
        GasStation obj = new GasStation();
        System.out.println(obj.canCompleteCircuit(gas, cost));
    }

    /**
     * 如果跑完 i 轮所剩下的tank油为负，则唯一有可能的解是 i + 1
     * 如果跑完所有轮，每轮 tank +　gas[i] 都 大于 cost[i]，则说明最后能跑完一轮
     * 注意要处理跑完最后一轮的情况，则可以将所有sumCost 与sumGas比较
     */
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
