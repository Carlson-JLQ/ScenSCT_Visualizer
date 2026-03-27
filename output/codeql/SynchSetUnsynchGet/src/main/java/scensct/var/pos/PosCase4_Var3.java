// A class with synchronized setter and unsynchronized getter, getter accesses volatile field but no write to it exists should be flagged as unsynchronized getter.
package scensct.var.pos;

public class PosCase4_Var3 {
    private volatile int status;
    private int value;

    // Synchronized setter inlined into a public method
    public void updateValue(int v) {
        setValueInternal(v);
    }

    private synchronized void setValueInternal(int v) {
        value = v; // No volatile write
    }

    // Unsynchronized getter extracted to a helper
    public int getValue() {
        return retrieveValue();
    }

    private int retrieveValue() {
        return value; // Accesses non-volatile field
    }

    // Volatile getter remains unchanged
    public int getStatus() {
        return status;
    }
}