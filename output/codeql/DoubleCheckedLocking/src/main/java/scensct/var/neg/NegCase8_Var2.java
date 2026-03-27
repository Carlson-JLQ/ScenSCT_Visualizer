// A method with null check on f inside synchronized block but not as inner if condition should not be flagged as double-checked locking.
package scensct.var.neg;

public class NegCase8_Var2 {
    private Object f;

    public void method() {
        // outer null check
        if (f == null) {
            // synchronized block with temporary variable
            Object lock = this;
            synchronized (lock) {
                // null check stored in a wrapper object
                BooleanHolder holder = new BooleanHolder(f == null);
                if (holder.value) {
                    f = new Object();
                }
            }
        }
    }

    private static class BooleanHolder {
        final boolean value;
        BooleanHolder(boolean v) { value = v; }
    }
}