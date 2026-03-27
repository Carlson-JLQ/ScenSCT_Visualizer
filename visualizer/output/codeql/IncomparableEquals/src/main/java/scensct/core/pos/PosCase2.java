// Top-level call to overridden equals with incomparable types should be flagged as positive.
package scensct.core.pos;

public class PosCase2 {
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
        // Declaring type A of equals, argument type B, no common subtype except Object
        A a = new A();
        B b = new B();
        boolean result = a.equals(b); // Should trigger report // [REPORTED LINE]
    }
}