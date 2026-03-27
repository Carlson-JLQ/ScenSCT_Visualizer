// Nested call to overridden equals with incomparable types should be flagged as positive.
package scensct.var.pos;

public class PosCase4_Var4 {
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
    static void nestedCallWrapper(X x, Y y) {
        anotherMethod(x.equals(y)); // [REPORTED LINE]
    }
    public static void main(String[] args) {
        // Variant 4: Move the entire nested call into a separate method that is invoked from main
        X x = new X();
        Y y = new Y();
        nestedCallWrapper(x, y);
    }
}