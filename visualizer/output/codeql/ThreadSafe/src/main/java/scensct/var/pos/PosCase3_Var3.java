// A @ThreadSafe class has a non-volatile, non-thread-safe field with at least one unsynchronized public write access should be flagged as improperly synchronized.
package scensct.var.pos;

import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public class PosCase3_Var3 {
    private String data; // Non-volatile, non-thread-safe field

    public synchronized void setData(String newData) {
        data = newData; // Synchronized write
    }

    public void unsafeWrite(String newData) {
        // Wrap in a try-catch block, but still unsynchronized
        try {
            data = newData; // Unsynchronized write // [REPORTED LINE]
        } catch (Exception e) {
            // Ignore
        }
    }
}