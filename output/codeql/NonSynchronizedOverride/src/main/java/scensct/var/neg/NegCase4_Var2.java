// A non-synchronized method that overrides a synchronized method with only a simple super call should not be flagged.
package scensct.var.neg;

public class NegCase4_Var2 {
    static class Super {
        public synchronized void sup(int x, String y) {}
    }
    
    static class Sub extends Super {
        @Override
        public void sup(int x, String y) { // [REPORTED LINE]
            // Introduce temporaries for parameters
            int localX = x;
            String localY = y;
            super.sup(localX, localY);
        }
    }
}