/**
 * Created by thanksgiving on 4/22/16.
 */
public class ContainerWithMostWater {
    public static void main(String[] args) {
        ContainerWithMostWater obj = new ContainerWithMostWater();
        int[] h = new int[]{1, 2, 1, 4, 1, 2, 5, 7, 1, 4, 5, 2, 1};
        int max = obj.maxArea(h);
        System.out.println(max);

    }

    /**
     * 每次最大面积为Math.min(height[i], height[j]) * (j - i))与当前最大面积比较
     * 如果height[i] < height[j]， 则增加 i 去继续update最大面积，否则减少 j
     */
    public int maxArea(int[] height) {
        if (height == null) return 0;
        int max = 0;
        int i = 0, j = height.length - 1;
        while (i < j) {
            max = Math.max(max, Math.min(height[i], height[j]) * (j - i));
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return max;
    }
}
