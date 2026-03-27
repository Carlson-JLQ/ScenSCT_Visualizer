// A synchronized method that overrides a synchronized method should not be flagged as unsynchronized override.
package scensct.var.neg;

public class NegCase3_Var3 {
    static class Super {
        public synchronized void action() {}
    }
    
    static class Sub extends Super {
        @Override
        public synchronized void action() {
            try {
                System.out.println("Synchronized override");
            } finally {
                // Cleanup placeholder
            }
        }
    }
}