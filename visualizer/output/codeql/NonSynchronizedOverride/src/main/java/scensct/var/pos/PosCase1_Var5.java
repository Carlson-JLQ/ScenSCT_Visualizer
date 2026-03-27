// A non-synchronized method overrides a synchronized method and contains no method calls in its body should be flagged as positive.
package scensct.var.pos;

public class PosCase1_Var5 {
    static class Parent {
        synchronized void method() {
            // synchronized method
        }
    }
    
    static class Child extends Parent {
        @Override
        void method() { // [REPORTED LINE]
            // Loop that does nothing, no method calls
            for (int i = 0; i < 0; i++) {
                // empty
            }
        }
    }
}