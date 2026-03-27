// A class with synchronized setter and getter with lock not this/class literal, getter accesses volatile field but no write to it exists should be flagged as unsynchronized getter.
package scensct.var.pos;

public class PosCase9_Var1 {
    private volatile int flag;
    private int data;
    private final Object customLock = new Object();

    public void setData(int v) {
        synchronized (this) {
            data = v;
        }
    }

    public int getData() {
        synchronized (customLock) {
            return data;
        }
    }

    public int readFlag() {
        return flag;
    }
}