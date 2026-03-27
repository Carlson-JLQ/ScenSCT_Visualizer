// A @ThreadSafe class has a non-volatile, non-thread-safe field with at least one unsynchronized public write access should be flagged as improperly synchronized.
package scensct.core.pos;

import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public class PosCase3 {
    private String data; // Non-volatile, non-thread-safe field

    public synchronized void setData(String newData) {
        data = newData; // Synchronized write
    }

    public void unsafeWrite(String newData) {
        data = newData; // Unsynchronized write (partial locking) // [REPORTED LINE]
    }
}