/**
 * Created by thanksgiving on 6/9/16.
 */
public class TrappingRainWater {
    public static void main(String[] args) {
        TrappingRainWater obj = new TrappingRainWater();
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        int res = obj.trap(height);
        System.out.println(res);
    }

    /**
     * 设置左右两个min, leftMin, rightMin
     * 如果leftMin < rightMin　则从左填充
     * 否则则从右填充
     */
    public int trap(int[] height) {
        if (height == null || height.length == 0) return 0;
        int l = 0, r = height.length - 1;
        int res = 0;
        int leftMin = height[l], rightMin = height[r];
        while (l < r) {
            if (leftMin < rightMin) {
                l++;
                if (height[l] < leftMin) {
                    res += leftMin - height[l];
                } else {
                    leftMin = height[l];
                }
            } else {
                r--;
                if (height[r] < rightMin) {
                    res += rightMin - height[r];
                } else {
                    rightMin = height[r];
                }
            }
        }
        return res;
    }
}
