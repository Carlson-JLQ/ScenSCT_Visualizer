// Top-level call to overridden equals with incomparable types should be flagged as positive.
package scensct.var.pos;

public class PosCase2_Var3 {
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
        // Variant 3: Use try-catch-finally to wrap the call
        A a = new A();
        B b = new B();
        try {
            boolean result = a.equals(b); // [REPORTED LINE]
        } catch (Exception e) {
            // ignore
        } finally {
            System.out.println("done");
        }
    }
}