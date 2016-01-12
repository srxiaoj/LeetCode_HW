import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        RestoreIPAddresses obj = new RestoreIPAddresses();
        String test = "010010";
        System.out.println(obj.restoreIpAddresses(test));
    }
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        int len = s.length();
        // make sure i, j and k are not out of boundary
        for (int i = 1; i < 4 && i < len - 2; i++) {
            for (int j = i + 1; j < i + 4 && j < len - 1; j++) {
                for (int k = j + 1; k < j + 4 && k < len; k++) {
                    String s1 = s.substring(0, i);
                    String s2 = s.substring(i, j);
                    String s3 = s.substring(j, k);
                    String s4 = s.substring(k, s.length());
                    if (isValid(s1) && isValid(s2) && isValid(s3) && isValid(s4)) {
                        res.add(s1 + "." + s2 + "." + s3 + "." + s4);
                    }
                }
            }
        }
        return res;
    }
    
    private boolean isValid(String s) {
        // s.charAt(0)=='0' && s.length() > 1 make sure that ip doesn't have '0' at beginning except 0 itself
        if (s == null || s.length() > 3 || s.length() < 1 || (s.charAt(0)=='0' && s.length() > 1)) {
            return false;
        }
        int ip = Integer.parseInt(s);
        if (ip < 0 || ip > 255) {
            return false;
        }
        return true;
    }
}
