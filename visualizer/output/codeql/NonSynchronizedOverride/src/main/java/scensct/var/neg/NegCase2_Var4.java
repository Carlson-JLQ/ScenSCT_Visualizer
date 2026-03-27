// A method that overrides a non-synchronized method should not be flagged as unsynchronized override.
package scensct.var.neg;

public class NegCase2_Var4 {
    static class Super {
        public void sup() {} // Non-synchronized
    }
    
    static class Sub extends Super {
        @Override
        public void sup() {
            // Delegate to a private helper method
            printMessage();
        }
        
        private void printMessage() {
            System.out.println("Override non-synchronized");
        }
    }
}