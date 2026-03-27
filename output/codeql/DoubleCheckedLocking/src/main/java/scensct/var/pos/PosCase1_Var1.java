// Double-checked locking on non-volatile, non-immutable field should be flagged as thread-unsafe.
package scensct.var.pos;

public class PosCase1_Var1 {
    private Object singleton; // renamed field, still non-volatile

    public Object getInstance() {
        Object localRef = singleton; // introduce temporary alias
        if (localRef == null) {
            synchronized (this) { // [REPORTED LINE]
                localRef = singleton; // re-read inside synchronized
                if (localRef == null) {
                    singleton = new Object(); // assignment to field
                    localRef = singleton;
                }
            }
        }
        return localRef;
    }
}