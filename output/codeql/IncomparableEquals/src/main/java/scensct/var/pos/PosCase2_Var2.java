// Top-level call to overridden equals with incomparable types should be flagged as positive.
package scensct.var.pos;

public class PosCase2_Var2 {
    static class A {
        @Override
        public boolean equals(Object obj) {
            return super.equals(obj);
        }
    }
    static class B {
        @Override
        public boolean equals(Object obj) {
            return super.equals(obj);
        }
    }
    // Variant 2: Extract the call into a helper method
    private static void compareObjects(A a, B b) {
        boolean result = a.equals(b); // [REPORTED LINE]
    }
    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        compareObjects(a, b);
    }
}