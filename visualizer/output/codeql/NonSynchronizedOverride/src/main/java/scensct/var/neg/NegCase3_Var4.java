// A synchronized method that overrides a synchronized method should not be flagged as unsynchronized override.
package scensct.var.neg;

public class NegCase3_Var4 {
    static class Super {
        public synchronized void process() {}
    }
    
    static class Sub extends Super {
        @Override
        public synchronized void process() {
            for (int i = 0; i < 1; i++) {
                System.out.println("Synchronized override");
            }
        }
    }
}