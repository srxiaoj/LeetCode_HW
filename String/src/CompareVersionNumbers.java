
public class CompareVersionNumbers {

    public static void main(String[] args) {
        CompareVersionNumbers obj = new CompareVersionNumbers();
        System.out.println(obj.compareVersion("1", "1.1"));
        System.out.println(obj.compareVersion("1.0", "1.1"));
        System.out.println(obj.compareVersion("01.0", "1.1"));
        System.out.println(obj.compareVersion("01", "1"));
        System.out.println(obj.compareVersion("1.0.1", "1"));
        System.out.println(obj.compareVersion("1.0.0", "1"));
    }

    /**
     * 将每个string用 '.' 分割，然后比较每一位分割的大小，如果哪一位大了则改数就大
     * 如果长度不等的时候，要考虑后面点是不是都是0
     */
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");

        int len1 = v1.length;
        int len2 = v2.length;
        if (len1 > len2) {
            for (int i = 0; i < len2; i++) {
                if (Integer.parseInt(v1[i]) < Integer.parseInt(v2[i])) {
                    return -1;
                } else if (Integer.parseInt(v1[i]) > Integer.parseInt(v2[i])) {
                    return 1;
                }
            }
            for (int i = len2; i < len1; i++) {
                if (Integer.parseInt(v1[i]) != 0) {
                    return 1;
                }
            }
        } else if (len1 < len2) {
            for (int i = 0; i < len1; i++) {
                if (Integer.parseInt(v1[i]) < Integer.parseInt(v2[i])) {
                    return -1;
                } else if (Integer.parseInt(v1[i]) > Integer.parseInt(v2[i])) {
                    return 1;
                }
            }
            for (int i = len1; i < len2; i++) {
                if (Integer.parseInt(v2[i]) != 0) {
                    return -1;
                }
            }
        } else {
            for (int i = 0; i < len1; i++) {
                if (Integer.parseInt(v1[i]) < Integer.parseInt(v2[i])) {
                    return -1;
                } else if (Integer.parseInt(v1[i]) > Integer.parseInt(v2[i])) {
                    return 1;
                }
            }
        }
        return 0;


       /* String[] list1 = version1.split("\\.");
        String[] list2 = version2.split("\\.");
        int length1 = list1.length;
        int length2 = list2.length;

        if (length1 > length2) {
            for (int i = 0; i < length2; i++) {
                if (Integer.parseInt(list1[i]) > Integer.parseInt(list2[i])) {
                    return 1;
                }
                if (Integer.parseInt(list1[i]) < Integer.parseInt(list2[i])) {
                    return -1;
                }
            }
            for (int i = length2; i < length1; i++) {
                if (Integer.parseInt(list1[i]) != 0) { // if the rest numbers are all 0
                    return 1;
                }
            }
            return 0;
        } else if (length1 < length2) {
            for (int i = 0; i < length1; i++) {
                if (Integer.parseInt(list1[i]) > Integer.parseInt(list2[i])) {
                    return 1;
                }
                if (Integer.parseInt(list1[i]) < Integer.parseInt(list2[i])) {
                    return -1;
                }
            }
            for (int i = length1; i < length2; i++) {
                if (Integer.parseInt(list2[i]) != 0) { // if the rest numbers are all 0
                    return -1;
                }
            }
            return 0;
        } else {
            for (int i = 0; i < length1; i++) {
                if (Integer.parseInt(list1[i]) > Integer.parseInt(list2[i])) {
                    return 1;
                }
                if (Integer.parseInt(list1[i]) < Integer.parseInt(list2[i])) {
                    return -1;
                }
            }
            return 0;
        }*/
    }
}
