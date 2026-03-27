// Nested call to overridden equals with incomparable types should be flagged as positive.
package scensct.var.pos;

public class PosCase4_Var2 {
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
    static boolean makeCall(X x, Y y) {
        return x.equals(y); // [REPORTED LINE]
    }
    public static void main(String[] args) {
        // Variant 2: Extract the equals call into a helper method, then pass result to anotherMethod
        X x = new X();
        Y y = new Y();
        anotherMethod(makeCall(x, y));
    }
}