// Double-checked locking on non-volatile, non-immutable field should be flagged as thread-unsafe.
package scensct.var.pos;

public class PosCase1_Var2 {
    private Object instance;

    public Object getInstance() {
        // outer check with boolean flag
        boolean needSync = instance == null;
        if (needSync) {
            synchronized (this) {
                // inner check with explicit condition variable
                boolean stillNull = instance == null;
                if (stillNull) {
                    instance = new Object();
                }
            }
        }
        return instance;
    }
}