// A @ThreadSafe class has a non-volatile, non-thread-safe field with an unsynchronized read and a partially synchronized write should be flagged as improperly synchronized.
package scensct.var.pos;

import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public class PosCase2_Var5 {
    private int value;

    public int getValue() {
        return this.value; // Explicit 'this' qualifier // [REPORTED LINE]
    }

    public synchronized void setValue(int newValue) {
        value = newValue; // Synchronized via method modifier
    }

    public void unsafeSet(int newValue) {
        int old = value; // Unsynchronized read (additional) // [REPORTED LINE]
        value = newValue; // Unsynchronized write // [REPORTED LINE]
    }
}