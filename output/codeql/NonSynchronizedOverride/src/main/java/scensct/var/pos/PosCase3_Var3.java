// A non-synchronized method overrides a synchronized method and contains only super calls to the overridden method with non-variable arguments, and no method calls inside casting expressions should be flagged as positive.
package scensct.var.pos;

public class PosCase3_Var3 {
    static class Parent {
        synchronized void method(int x) {
            // synchronized method
        }
    }
    
    static class Child extends Parent {
        @Override
        void method(int x) { // [REPORTED LINE]
            if (true) {
                for (int i = 0; i < 1; i++) {
                    super.method(42);
                    break;
                }
            }
        }
    }
}