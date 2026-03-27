// Nested call to overridden equals with incomparable types should be flagged as positive.
package scensct.var.pos;

public class PosCase4_Var3 {
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
        // Variant 3: Wrap the call in a trivial if-else that always takes the true branch
        X x = new X();
        Y y = new Y();
        if (true) {
            anotherMethod(x.equals(y)); // [REPORTED LINE]
        } else {
            // dead code
        }
    }
}