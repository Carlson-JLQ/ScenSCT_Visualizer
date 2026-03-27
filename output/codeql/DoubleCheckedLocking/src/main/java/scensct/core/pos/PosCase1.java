// Double-checked locking on non-volatile, non-immutable field should be flagged as thread-unsafe.
package scensct.core.pos;

public class PosCase1 {
    private Object instance; // Non-volatile, non-immutable field

    public Object getInstance() {
        if (instance == null) { // Outer null check
            synchronized (this) { // [REPORTED LINE]
                if (instance == null) { // Inner null check
                    instance = new Object(); // Initialization inside synchronized block
                }
            }
        }
        return instance;
    }
}