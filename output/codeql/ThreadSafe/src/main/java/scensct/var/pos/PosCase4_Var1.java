// A @ThreadSafe class has a non-volatile, non-thread-safe field accessed with inconsistent monitor objects should be flagged as improperly synchronized.
package scensct.var.pos;

import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public class PosCase4_Var1 {
    private int total; // renamed field // [REPORTED LINE]
    private final Object mutex = new Object(); // renamed lock

    public synchronized void addOne() { // renamed method
        total = total + 1; // rewritten increment
    }

    public void subtractOne() { // renamed method
        synchronized (mutex) {
            int tmp = total;
            total = tmp - 1; // decrement via temporary
        }
    }
}