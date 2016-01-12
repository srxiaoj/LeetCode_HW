
public class CompareVersionNumbers {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        CompareVersionNumbers obj = new CompareVersionNumbers();
        String v1 = "1";
        String v2 = "1.1";
        System.out.println(obj.compareVersion(v1, v2));
    }
    public int compareVersion(String version1, String version2) {
        String[] list1 = version1.split("\\.");
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
            for (int i = length2; i < length1; i++)
            {
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
            for (int i = length1; i < length2; i++)
            {
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
        }
    }
}
