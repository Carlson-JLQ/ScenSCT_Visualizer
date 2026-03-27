// Top-level call to overridden equals with incomparable types should be flagged as positive.
package scensct.var.pos;

public class PosCase2_Var1 {
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
    public static void main(String[] args) {
        // Variant 1: Introduce a temporary variable and a conditional that always executes
        A a = new A();
        B b = new B();
        if (args.length >= 0) { // always true
            boolean result = a.equals(b); // [REPORTED LINE]
        }
    }
}