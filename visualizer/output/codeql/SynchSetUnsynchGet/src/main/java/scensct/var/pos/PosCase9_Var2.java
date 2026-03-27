// A class with synchronized setter and getter with lock not this/class literal, getter accesses volatile field but no write to it exists should be flagged as unsynchronized getter.
package scensct.var.pos;

public class PosCase9_Var2 {
    private volatile int status;
    private int counter;
    private final Object lockObj = createLock();

    private static Object createLock() {
        return new Object();
    }

    public synchronized void setCounter(int val) {
        counter = val;
    }

    public int retrieveCounter() {
        Object l = lockObj;
        synchronized (l) {
            int result = counter;
            return result;
        }
    }

    public int getStatus() {
        return status;
    }
}