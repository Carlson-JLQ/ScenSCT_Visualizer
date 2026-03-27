// A class with synchronized setter and getter with lock not this/class literal, getter accesses volatile field but no write to it exists should be flagged as unsynchronized getter.
package scensct.var.pos;

public class PosCase9_Var3 {
    private volatile int state;
    private int amount;
    private final Object otherLock;

    public PosCase9_Var3() {
        otherLock = new Object();
    }

    public synchronized void updateAmount(int a) {
        amount = a;
    }

    public int fetchAmount() {
        synchronized (otherLock) {
            int tmp = amount;
            return tmp;
        }
    }

    public int checkState() {
        return state;
    }
}