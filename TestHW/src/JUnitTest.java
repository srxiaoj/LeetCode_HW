import static org.junit.Assert.*;

/**
 * Created by Administrator on 2016/10/10.
 */
public class JUnitTest {
    @org.junit.Test
    public void square() throws Exception {
        JUnit obj = new JUnit();
        int output = obj.square(5);
        assertEquals(25, output);
        assertEquals(26, output);
    }

}