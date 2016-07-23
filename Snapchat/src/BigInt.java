class BigInt {
    String number;

    public BigInt(String number) {
        this.number = number;
    }

    public String addBigInt(String toAdd) {
        StringBuilder sb = new StringBuilder();
        int n1 = number.length();
        int n2 = toAdd.length();
        int i = n1 - 1, j = n2 - 1;
        int num = 0;
        while (i >= 0 || j >= 0) {
            if (i >= 0) {
                num += number.charAt(i) - '0';
                i--;
            }
            if (j >= 0) {
                num += toAdd.charAt(j) - '0';
                j--;
            }

            sb.append(num % 10);
            if (num > 9) {
                num /= 10;
            } else {
                num = 0;
            }
        }
        if (num > 0) {
            sb.append(num);
        }
        return sb.reverse().toString();
    }

    public String subtractBigInt(String toSub) {
        return subtract(number, toSub);
    }

    // a - b
    private String subtract(String a, String b) {
        if (!compareBigInt(a, b)) {
            String res = "-" + subtract(b, a);
            return res;
        }
        int n1 = a.length();
        int n2 = b.length();
        int i = n1 - 1, j = n2 - 1;
        StringBuilder sb = new StringBuilder();
        int num = 0;
        while (i >= 0 || j >= 0) {
            num += a.charAt(i) - '0';
            if (j >= 0) {
                int bDigit = b.charAt(j) - '0';
                if (num >= bDigit) {
                    sb.append(num - bDigit);
                    num = 0;
                } else {
                    sb.append(num - bDigit + 10);
                    num = -1;
                }
                j--;
            } else {
                sb.append(num);
                num = 0;
            }
            i--;
        }
        int start = sb.length() - 1;
        while (start >= 0 && sb.charAt(start) == '0') {
            start--;
        }
        sb = new StringBuilder(sb.substring(0, start + 1));
        if (sb.length() == 0) return "0";
        return sb.reverse().toString();
    }

    public String multiplyInt(String toMulti) {
        return null;
    }

    public boolean compareBigInt(String a, String b) {
        int len1 = a.length(), len2 = b.length();
        if (len1 > len2) return true;
        if (len1 < len2) return false;
        int i = 0;
        while (i < len1) {
            if (a.charAt(i) > b.charAt(i)) {
                return true;
            } else if (a.charAt(i) < b.charAt(i)) {
                return false;
            }
            i++;
        }
        return true;
    }


    public static void main(String[] args) {
        BigInt a = new BigInt("1111");
        System.out.println(a.subtractBigInt("1123"));
        System.out.println(a.subtractBigInt("1111"));
        System.out.println(a.subtractBigInt("999"));
        System.out.println(a.subtractBigInt("200"));
        System.out.println(a.subtractBigInt("99"));



        // compare function
//        System.out.println(a.compareBigInt("12123", "1324364363456"));
//        System.out.println(a.compareBigInt("121", "132"));
//        System.out.println(a.compareBigInt("132", "132"));
//        System.out.println(a.compareBigInt("231", "1321"));



//        System.out.println(a.addBigInt("999"));
//        System.out.println(a.addBigInt("12309810932480325"));
//        System.out.println(a.addBigInt("1230127371"));
//        System.out.println(a.addBigInt("9879384750918023"));
//        System.out.println(a.addBigInt("999999999999999999"));
    }
}