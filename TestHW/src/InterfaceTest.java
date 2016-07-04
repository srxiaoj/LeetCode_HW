/**
 * Created by thanksgiving on 7/3/16.
 */
public class InterfaceTest {
    public static void main(String[] args) {
        A a = new B();
    }

    static class A {
        A() {
            foo();
        }

        void foo() {
            System.out.println("This is A.");
        }
    }


    static class B extends A {
        B() {
//            super();
            foo();
        }

        void foo() {
            System.out.println("This is B.");
        }
    }
}
