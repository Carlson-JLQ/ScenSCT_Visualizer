// A synchronized method that overrides a synchronized method should not be flagged as unsynchronized override.
package scensct.var.neg;

public class NegCase3_Var1 {
    static class Base {
        protected synchronized void perform() {}
    }
    
    static class Derived extends Base {
        @Override
        public synchronized void perform() {
            String msg = "Synchronized override";
            System.out.println(msg);
        }
    }
}