// A @ThreadSafe class has a non-volatile, non-thread-safe field with at least one unsynchronized public write access should be flagged as improperly synchronized.
package scensct.var.pos;

import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public class PosCase3_Var5 {
    private String data; // Non-volatile, non-thread-safe field

    public synchronized void setData(String newData) {
        data = newData; // Synchronized write
    }

    // Overload the unsafe write with different parameter type, but same field write
    public void unsafeWrite(String newData) {
        data = newData; // Unsynchronized write // [REPORTED LINE]
    }

    public void unsafeWrite(StringBuilder builder) {
        data = builder.toString(); // Another unsynchronized write via different public method // [REPORTED LINE]
    }
}