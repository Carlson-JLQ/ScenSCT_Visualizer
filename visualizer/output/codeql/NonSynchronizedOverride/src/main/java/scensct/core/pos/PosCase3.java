// A non-synchronized method overrides a synchronized method and contains only super calls to the overridden method with non-variable arguments, and no method calls inside casting expressions should be flagged as positive.
package scensct.core.pos;

public class PosCase3 {
    static class Parent {
        synchronized void method(int x) {
            // synchronized method
        }
    }
    
    static class Child extends Parent {
        @Override
        void method(int x) { // [REPORTED LINE]
            // Contains only super call to overridden method with literal argument - should be flagged
            super.method(42);
        }
    }
}