// Top-level call to overridden equals with incomparable types should be flagged as positive.
package scensct.var.pos;

import java.util.function.Supplier;

public class PosCase2_Var4 {
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
        // Variant 4: Use a Supplier to defer the call
        A a = new A();
        B b = new B();
        Supplier<Boolean> supplier = () -> a.equals(b); // [REPORTED LINE]
        boolean result = supplier.get();
    }
}