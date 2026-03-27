// A class with synchronized setter and getter with lock not this/class literal, getter accesses volatile field but writes to it are outside synchronized setter should be flagged as unsynchronized getter.
package scensct.var.pos;

public class PosCase10_Var1 {
    private volatile int count;
    private int data;
    private final Object lock = new Object();

    public void setValue(int v) {
        synchronized (this) {
            data = v;
        }
    }

    public void bumpCount() {
        count++;
    }

    public int getValue() {
        synchronized (lock) {
            return data;
        }
    }

    public int getCount() {
        return count;
    }
}