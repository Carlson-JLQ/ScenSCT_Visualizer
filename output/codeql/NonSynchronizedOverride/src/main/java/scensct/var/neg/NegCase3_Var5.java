// A synchronized method that overrides a synchronized method should not be flagged as unsynchronized override.
package scensct.var.neg;

public class NegCase3_Var5 {
    static class Super {
        public synchronized void operation() {}
    }
    
    static class Sub extends Super {
        @Override
        public synchronized void operation() {
            logMessage("Synchronized override");
        }
        
        private void logMessage(String msg) {
            System.out.println(msg);
        }
    }
}