// A method that overrides a non-synchronized method should not be flagged as unsynchronized override.
package scensct.core.neg;

public class NegCase2 {
    static class Super {
        // This method is not synchronized, so overriding without synchronization is fine.
        public void sup() {}
    }
    
    static class Sub extends Super {
        @Override
        public void sup() { // Overrides non-synchronized method, no issue.
            System.out.println("Override non-synchronized");
        }
    }
}