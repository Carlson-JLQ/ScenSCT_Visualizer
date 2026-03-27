// A @ThreadSafe class has a non-volatile, non-thread-safe field with an unsynchronized read and a partially synchronized write should be flagged as improperly synchronized.
package scensct.var.pos;

import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public class PosCase2_Var3 {
    private int value;

    public int getValue() {
        return readValue(); // Extract unsynchronized read to helper
    }

    private int readValue() {
        return value; // Unsynchronized read in helper // [REPORTED LINE]
    }

    public void setValue(int newValue) {
        writeSynchronized(newValue);
    }

    private void writeSynchronized(int v) {
        synchronized (this) {
            value = v; // Synchronized write in helper
        }
    }

    public void unsafeSet(int newValue) {
        writeUnsynchronized(newValue);
    }

    private void writeUnsynchronized(int v) {
        value = v; // Unsynchronized write in helper // [REPORTED LINE]
    }
}