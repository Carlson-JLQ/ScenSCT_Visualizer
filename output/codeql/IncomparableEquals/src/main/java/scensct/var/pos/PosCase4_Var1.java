// Nested call to overridden equals with incomparable types should be flagged as positive.
package scensct.var.pos;

public class PosCase4_Var1 {
    static class X {
        @Override
        public boolean equals(Object obj) {
            return super.equals(obj);
        }
    }
    static class Y {
        @Override
        public boolean equals(Object obj) {
            return super.equals(obj);
        }
    }
    static void anotherMethod(boolean b) {
        // Dummy method
    }
    public static void main(String[] args) {
        // Variant 1: Introduce a temporary variable and reorder statements
        Y y = new Y();
        X x = new X();
        boolean temp = x.equals(y); // [REPORTED LINE]
        anotherMethod(temp);
    }
}