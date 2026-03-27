// A non-synchronized method overrides a synchronized method and contains no method calls in its body should be flagged as positive.
package scensct.core.pos;

public class PosCase1 {
    static class Parent {
        synchronized void method() {
            // synchronized method
        }
    }
    
    static class Child extends Parent {
        @Override
        void method() { // [REPORTED LINE]
            // No method calls in body - should be flagged
        }
    }
}