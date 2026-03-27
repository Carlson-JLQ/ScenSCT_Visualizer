// A non-synchronized method that overrides a synchronized method with only a simple super call should not be flagged.
package scensct.var.neg;

public class NegCase4_Var4 {
    static class Super {
        public synchronized void sup(int x, String y) {}
    }
    
    static class Sub extends Super {
        @Override
        public void sup(int x, String y) { // [REPORTED LINE]
            // Delegate via a private helper method that does nothing but forward
            delegateToSuper(x, y);
        }
        
        private void delegateToSuper(int p1, String p2) {
            super.sup(p1, p2);
        }
    }
}