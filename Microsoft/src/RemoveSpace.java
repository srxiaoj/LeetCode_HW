/**
 * Created by thanksgiving on 3/31/16.
 */
public class RemoveSpace {
    public static void main(String[] args) {
        RemoveSpace obj = new RemoveSpace();
        String s1 = "this    is  my   test.";
        s1 = obj.removeSpace(s1);
        System.out.println(s1);
    }



    public String removeSpace(String s) {
        s = s.trim();
//        s = s.replaceAll("\\s+", " ");
        s = s.replaceAll(" +", " ");
        return s;
    }
}
