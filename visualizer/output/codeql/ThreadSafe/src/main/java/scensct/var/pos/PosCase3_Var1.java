// A @ThreadSafe class has a non-volatile, non-thread-safe field with at least one unsynchronized public write access should be flagged as improperly synchronized.
package scensct.var.pos;

import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public class PosCase3_Var1 {
    private String data; // Non-volatile, non-thread-safe field

    public synchronized void setData(String newData) {
        data = newData; // Synchronized write
    }

    public void unsafeWrite(String input) {
        // Introduce a temporary variable and a conditional, but still write unsynchronized
        String temp = input;
        if (temp != null) {
            data = temp; // Unsynchronized write // [REPORTED LINE]
        }
    }
}