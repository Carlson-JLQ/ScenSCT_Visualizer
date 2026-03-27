// A method that overrides a non-synchronized method should not be flagged as unsynchronized override.
package scensct.var.neg;

public class NegCase2_Var2 {
    interface ISuper {
        void sup(); // Interface methods are implicitly non-synchronized
    }
    
    static class Super implements ISuper {
        public void sup() {} // Implements, still non-synchronized
    }
    
    static class Sub extends Super {
        @Override
        public void sup() {
            if (Math.random() > 0.5) {
                System.out.println("Override non-synchronized");
            } else {
                System.out.println("Alternative path");
            }
        }
    }
}