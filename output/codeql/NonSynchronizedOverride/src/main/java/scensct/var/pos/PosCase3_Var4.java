// A non-synchronized method overrides a synchronized method and contains only super calls to the overridden method with non-variable arguments, and no method calls inside casting expressions should be flagged as positive.
package scensct.var.pos;

import static java.lang.Math.abs;

public class PosCase3_Var4 {
    static class Parent {
        synchronized void method(int x) {
            // synchronized method
        }
    }
    
    static class Child extends Parent {
        @Override
        final void method(int x) { // [REPORTED LINE]
            super.method(abs(-42));
        }
    }
}