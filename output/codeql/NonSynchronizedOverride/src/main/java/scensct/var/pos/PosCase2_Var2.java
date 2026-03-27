// A non-synchronized method overrides a synchronized method and contains method calls that are either super calls to the overridden method with non-variable arguments, or calls not via super, or super calls to other methods should be flagged as positive.
package scensct.var.pos;

public class PosCase2_Var2 {
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
            // Wrap super call in a conditional that always executes
            if (true) {
                super.otherMethod();
            }
        }
    }
}