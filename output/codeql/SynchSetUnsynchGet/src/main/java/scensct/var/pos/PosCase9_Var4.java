// A class with synchronized setter and getter with lock not this/class literal, getter accesses volatile field but no write to it exists should be flagged as unsynchronized getter.
package scensct.var.pos;

public class PosCase9_Var4 {
    private volatile int indicator;
    private int total;
    private final Object separateLock = new Object();

    public void setTotal(int t) {
        synchronized (this) {
            total = t;
        }
    }

    public int getTotal() {
        Object lock = separateLock;
        synchronized (lock) {
            try {
                return total;
            } finally {
                // dummy finally to stress flow analysis
            }
        }
    }

    public int readIndicator() {
        return indicator;
    }
}