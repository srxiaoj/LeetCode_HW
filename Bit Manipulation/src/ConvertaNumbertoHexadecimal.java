/**
 * Created by Administrator on 2016/10/21.
 */
public class ConvertaNumbertoHexadecimal {
    public static void main(String[] args) {
        System.out.println(toHex(26));
        System.out.println(toHex(-1));
    }

    public static String toHex(int num) {
        char[] map = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
        if(num == 0) return "0";
        String res = "";
        while(num != 0){
            // 0xf == 0x0000000f == 15
            res = map[(num & 0xf)] + res;
            num = (num >>> 4);
        }
        return res;
    }
}
