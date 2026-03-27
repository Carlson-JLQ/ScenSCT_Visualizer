// A non-synchronized method that overrides a synchronized method with only a simple super call should not be flagged.
package scensct.core.neg;

public class NegCase4 {
    static class Super {
        public synchronized void sup(int x, String y) {}
    }
    
    static class Sub extends Super {
        @Override
        public void sup(int x, String y) { // Non-synchronized but only delegates via super call.
            super.sup(x, y); // Simple super call with parameters as variable accesses.
        }
    }
}