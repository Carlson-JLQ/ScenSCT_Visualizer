// Top-level call to overridden equals with incomparable types should be flagged as positive.
package scensct.var.pos;

public class PosCase2_Var5 {
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
    // Variant 5: Inline the creation and call within a loop
    public static void main(String[] args) {
        for (int i = 0; i < 1; i++) {
            boolean result = new A().equals(new B()); // [REPORTED LINE]
        }
    }
}