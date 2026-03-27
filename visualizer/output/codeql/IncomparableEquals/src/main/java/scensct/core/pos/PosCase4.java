// Nested call to overridden equals with incomparable types should be flagged as positive.
package scensct.core.pos;

public class PosCase4 {
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
        // Dummy method to nest the equals call
    }
    public static void main(String[] args) {
        // Declaring type X of equals, argument type Y, no common subtype except Object
        X x = new X();
        Y y = new Y();
        // Nested inside method call (anotherMethod) whose name does not start with "assert"
        anotherMethod(x.equals(y)); // Should trigger report // [REPORTED LINE]
    }
}