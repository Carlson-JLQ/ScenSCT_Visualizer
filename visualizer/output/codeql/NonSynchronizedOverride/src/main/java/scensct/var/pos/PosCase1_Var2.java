// A non-synchronized method overrides a synchronized method and contains no method calls in its body should be flagged as positive.
package scensct.var.pos;

public class PosCase1_Var2 {
    static class Parent {
        synchronized void method() {
            // synchronized method
        }
    }
    
    static class Child extends Parent {
        @Override
        void method() { // [REPORTED LINE]
            // Body with a comment and a trivial local variable, but no method calls
            int x = 42;
        }
    }
}