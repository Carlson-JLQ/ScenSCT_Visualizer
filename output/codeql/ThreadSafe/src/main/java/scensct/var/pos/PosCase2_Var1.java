// A @ThreadSafe class has a non-volatile, non-thread-safe field with an unsynchronized read and a partially synchronized write should be flagged as improperly synchronized.
package scensct.var.pos;

import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public class PosCase2_Var1 {
    private int data; // Renamed field

    public int retrieve() { // Renamed method
        return data; // Unsynchronized read // [REPORTED LINE]
    }

    public void assign(int val) { // Renamed method
        synchronized (this) {
            data = val; // Synchronized write
        }
    }

    public void directAssign(int val) { // Renamed method
        data = val; // Unsynchronized write // [REPORTED LINE]
    }
}