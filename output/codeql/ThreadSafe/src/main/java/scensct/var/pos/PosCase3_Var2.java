// A @ThreadSafe class has a non-volatile, non-thread-safe field with at least one unsynchronized public write access should be flagged as improperly synchronized.
package scensct.var.pos;

import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public class PosCase3_Var2 {
    private String data; // Non-volatile, non-thread-safe field

    public synchronized void setData(String newData) {
        data = newData; // Synchronized write
    }

    // Rename method and use a helper for the write, but keep it unsynchronized
    public void updateData(String newData) {
        performUpdate(newData);
    }

    private void performUpdate(String value) {
        data = value; // Unsynchronized write via private helper // [REPORTED LINE]
    }
}