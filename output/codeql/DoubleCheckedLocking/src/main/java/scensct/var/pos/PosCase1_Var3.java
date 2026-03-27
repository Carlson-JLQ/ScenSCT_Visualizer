// Double-checked locking on non-volatile, non-immutable field should be flagged as thread-unsafe.
package scensct.var.pos;

public class PosCase1_Var3 {
    private Object instance;

    public Object getInstance() {
        if (instance != null) {
            return instance; // early return instead of if-null
        }
        synchronized (this) {
            if (instance == null) {
                instance = new Object();
            }
            return instance; // return inside synchronized block
        }
    }
}