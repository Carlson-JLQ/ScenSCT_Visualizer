// A non-synchronized method that overrides a synchronized method with only a simple super call should not be flagged.
package scensct.var.neg;

public class NegCase4_Var5 {
    static class Super {
        public synchronized void sup(int x, String y) {}
    }
    
    static class Sub extends Super {
        @Override
        public void sup(int x, String y) { // [REPORTED LINE]
            // Use a try-finally with no-op in try, super call in finally
            try {
                // empty
            } finally {
                super.sup(x, y);
            }
        }
    }
}