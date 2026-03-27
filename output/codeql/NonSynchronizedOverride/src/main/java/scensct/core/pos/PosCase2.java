// A non-synchronized method overrides a synchronized method and contains method calls that are either super calls to the overridden method with non-variable arguments, or calls not via super, or super calls to other methods should be flagged as positive.
package scensct.core.pos;

public class PosCase2 {
    static class Parent {
        synchronized void method() {
            // synchronized method
        }
        
        synchronized void otherMethod() {
            // another synchronized method
        }
    }
    
    static class Child extends Parent {
        @Override
        void method() { // [REPORTED LINE]
            // Contains super call to other method - should be flagged
            super.otherMethod();
        }
    }
}