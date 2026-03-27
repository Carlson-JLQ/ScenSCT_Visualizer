// Nested call to overridden equals with incomparable types should be flagged as positive.
package scensct.var.pos;

public class PosCase4_Var5 {
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
        // Variant 5: Use a try-catch block around the call (catch block does nothing)
        X x = new X();
        Y y = new Y();
        try {
            anotherMethod(x.equals(y)); // [REPORTED LINE]
        } catch (Exception e) {
            // ignore
        }
    }
}