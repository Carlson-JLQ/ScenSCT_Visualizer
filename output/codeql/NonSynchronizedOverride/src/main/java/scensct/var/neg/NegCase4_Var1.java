// A non-synchronized method that overrides a synchronized method with only a simple super call should not be flagged.
package scensct.var.neg;

public class NegCase4_Var1 {
    static class Super {
        public synchronized void sup(int x, String y) {}
    }
    
    static class Sub extends Super {
        @Override
        public void sup(final int a, final String b) {
            // Use final parameters and rename them
            super.sup(a, b);
        }
    }
}