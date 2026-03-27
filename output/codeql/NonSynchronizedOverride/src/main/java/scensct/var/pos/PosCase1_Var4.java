// A non-synchronized method overrides a synchronized method and contains no method calls in its body should be flagged as positive.
package scensct.var.pos;

public class PosCase1_Var4 {
    static class Parent {
        synchronized void method() {
            // synchronized method
        }
    }
    
    static class Child extends Parent {
        @Override
        void method() { // [REPORTED LINE]
            // Conditional block that never executes, but contains no method calls
            if (false) {
                // unreachable
            }
        }
    }
}