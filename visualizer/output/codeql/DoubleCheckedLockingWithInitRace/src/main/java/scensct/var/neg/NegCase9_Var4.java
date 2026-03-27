// Outer if condition is not an equality test should not be flagged as a race condition.
package scensct.var.neg;

import java.util.concurrent.locks.ReentrantLock;

public class NegCase9_Var4 {
    private Object field;
    private final ReentrantLock lock = new ReentrantLock();

    public Object getField() {
        if (!false) { // non-equality boolean literal (negation)
            lock.lock();
            try {
                if (field == null) {
                    field = new Object();
                }
            } finally {
                lock.unlock();
            }
        }
        return field;
    }
}