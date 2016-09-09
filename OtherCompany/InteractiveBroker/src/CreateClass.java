/**
 * Created by thanksgiving on 9/8/16.
 */
public class CreateClass {
    public Object createObject(String classname) throws Exception {
        Object obj = null;
        Class theClass = Class.forName(classname);
        obj = theClass.newInstance();
        return obj;
    }

    private static final char SEP = 0x20;
    private static final int MES = 1;
    public static void main(String[] args) {
        System.out.println(SEP + MES + "=A");
    }
}
