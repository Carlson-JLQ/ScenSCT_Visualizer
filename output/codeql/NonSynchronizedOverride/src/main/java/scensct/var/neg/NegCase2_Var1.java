// A method that overrides a non-synchronized method should not be flagged as unsynchronized override.
package scensct.var.neg;

public class NegCase2_Var1 {
    static abstract class Base {
        // Non-synchronized method to be overridden
        public abstract void sup();
    }
    
    static class Super extends Base {
        @Override
        public void sup() {} // Still non-synchronized
    }
    
    static class Sub extends Super {
        @Override
        public void sup() {
            // Override remains fine
            String msg = "Override non-synchronized";
            System.out.println(msg);
        }
    }
}