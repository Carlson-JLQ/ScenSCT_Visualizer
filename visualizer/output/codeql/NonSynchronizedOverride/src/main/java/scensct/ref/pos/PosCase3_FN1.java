// A non-synchronized method overrides a synchronized method and contains only super calls to the overridden method with non-variable arguments, and no method calls inside casting expressions should be flagged as positive.
package scensct.ref.pos;

public class PosCase3_FN1 {
    static class Parent {
        synchronized void method() {
            // synchronized method
        }
    }
    
    static class Child extends Parent {
        @Override
        void method() {
            // Contains only super call to overridden method with literal argument - should be flagged
            super.method();
        }
    }
}