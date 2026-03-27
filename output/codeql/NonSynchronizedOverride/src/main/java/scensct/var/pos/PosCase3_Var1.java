// A non-synchronized method overrides a synchronized method and contains only super calls to the overridden method with non-variable arguments, and no method calls inside casting expressions should be flagged as positive.
package scensct.var.pos;

public class PosCase3_Var1 {
    static class Parent {
        synchronized void perform(int value) {
            // synchronized method
        }
    }
    
    static class Child extends Parent {
        @Override
        void perform(int value) { // [REPORTED LINE]
            final int arg = 42;
            try {
                super.perform(arg);
            } catch (Exception e) {
                throw e;
            } finally {
                // empty finally, no extra calls
            }
        }
    }
}