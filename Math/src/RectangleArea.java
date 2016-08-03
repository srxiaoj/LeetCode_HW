/**
 * Created by thanksgiving on 1/6/16.
 */
public class RectangleArea {
    public static void main(String[] args) {
        RectangleArea obj = new RectangleArea();
        System.out.println(obj.computeArea(-3, 0, 3, 4, 0, -1, 9, 2));
    }

    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        // two rectangular have no overlap in y axis
        if (C <= E || A >= G) return (C - A) * (D - B) + (G - E) * (H - F);
        // two rectangular have no overlap in x axis
        if (B >= H || F >= D) return (C - A) * (D - B) + (G - E) * (H - F);

        int width = Math.min(C, G) - Math.max(A, E);
        int height = Math.min(D, H) - Math.max(B, F);
        return (C - A) * (D - B) + (G - E) * (H - F) - width * height;
    }
}
