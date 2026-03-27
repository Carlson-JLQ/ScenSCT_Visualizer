// A @ThreadSafe class has a non-volatile, non-thread-safe field with at least one unsynchronized public write access should be flagged as improperly synchronized.
package scensct.var.pos;

import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public class PosCase3_Var4 {
    private String data; // Non-volatile, non-thread-safe field

    // Inline the synchronized write logic into a public method, but keep separate unsynchronized method
    public synchronized void setData(String newData) {
        this.data = newData; // Synchronized write
    }

    public void unsafeWrite(String newData) {
        this.data = newData; // Unsynchronized write with explicit 'this' // [REPORTED LINE]
    }
}