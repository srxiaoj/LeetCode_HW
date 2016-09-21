/**
 * Created by thanksgiving on 9/20/16.
 */
public class SingletonClass {
    private static SingletonClass singleton = null;
    public SingletonClass() {

    }
    public static SingletonClass getInstance() {
        if (singleton == null) {
            singleton = new SingletonClass();
        }
        return singleton;
    }
}
