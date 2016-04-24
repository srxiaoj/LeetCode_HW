/**
 * Created by thanksgiving on 4/24/16.
 */
public class IntegertoRoman {
    public static void main(String[] args) {
        IntegertoRoman obj = new IntegertoRoman();
        System.out.println(obj.intToRoman(181));
    }

    /**
     * symbol[] 的建立格式非常重要， 保证num可以按照该array去减少， 并且append symbol[i]
     * @param num
     * @return
     */
    public String intToRoman(int num) {
        String symbol[] = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int value[] = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < symbol.length; i++) {
            int base = num / value[i];
            // 30 / 10 = 2, need Three XXX
            while (base != 0) {
                base--;
                result.append(symbol[i]);
            }
            num = num % value[i];
        }
        return result.toString();
    }
}
