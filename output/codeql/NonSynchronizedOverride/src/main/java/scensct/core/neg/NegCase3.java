// A synchronized method that overrides a synchronized method should not be flagged as unsynchronized override.
package scensct.core.neg;

public class NegCase3 {
    static class Super {
        public synchronized void sup() {}
    }
    
    static class Sub extends Super {
        @Override
        public synchronized void sup() { // Also synchronized, so no violation.
            System.out.println("Synchronized override");
        }
    }
}