/**
 * Created by thanksgiving on 9/8/16.
 */
public class PayrollSystem {
    private static PayrollSystem payrollSystem = new PayrollSystem();

    private PayrollSystem() {

    }

    public static PayrollSystem getInstance() {
        return payrollSystem;
    }

    public static void main(String[] args) {
//        PayrollSystem payrollSystem = new PayrollSystem.getInstance();
        PayrollSystem payrollSystem = new PayrollSystem();
    }
}
