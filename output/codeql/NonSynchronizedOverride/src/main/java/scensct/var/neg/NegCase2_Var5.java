// A method that overrides a non-synchronized method should not be flagged as unsynchronized override.
package scensct.var.neg;

public class NegCase2_Var5 {
    static class Super {
        public void sup() {} // Non-synchronized
    }
    
    static class Sub extends Super {
        @Override
        public void sup() {
            // Wrap in try-catch-finally with no effect on synchronization
            try {
                System.out.println("Override non-synchronized");
            } catch (Exception e) {
                throw e;
            } finally {
                // Cleanup placeholder
                int x = 0;
            }
        }
    }
}