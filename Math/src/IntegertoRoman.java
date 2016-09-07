/**
 * Created by thanksgiving on 4/24/16.
 */
public class IntegertoRoman {
    public static void main(String[] args) {
        IntegertoRoman obj = new IntegertoRoman();
        System.out.println(obj.intToRoman(181));
        System.out.println(obj.intToRoman(1024));
    }

    /**
     * symbol[] 的建立格式非常重要， 保证num可以按照该array去减少， 并且append symbol[i]
     * @param num
     * @return
     */
    public String intToRoman(int num) {
        String symbol[] = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int value[] =     {1000, 900, 500, 400, 100,   90,   50,  40,   10,   9,   5,   4,    1};
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < value.length && num > 0) {
            if (num >= value[i]) {
                int count = num / value[i];
                for (int j = 0; j < count; j++) {
                    sb.append(symbol[i]);
                }
                num -= count * value[i];
            }
            i++;
        }
        return sb.toString();

        /*int start = 0;
        while (num > 0) {
            if (start < value.length && num < value[start]) {
                start++;
            } else {
                for (int i = 0; i < num / value[start]; i++) {
                    sb.append(symbol[start]);
                }
                num -= num / value[start] * value[start];
            }
        }
        return sb.toString();*/
    }
}
