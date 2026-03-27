// A synchronized method that overrides a synchronized method should not be flagged as unsynchronized override.
package scensct.var.neg;

public class NegCase3_Var2 {
    interface Task {
        void execute();
    }
    
    static class Super implements Task {
        public synchronized void execute() {}
    }
    
    static class Sub extends Super {
        @Override
        public synchronized void execute() {
            if (System.currentTimeMillis() > 0) {
                System.out.println("Synchronized override");
            }
        }
    }
}