// Double-checked locking with assignment to another field after the field assignment should be flagged as potential race condition.
package scensct.core.pos;

public class PosCase1 {
    private Object f;
    private Object otherField;

    public Object getF() {
        if (f == null) { // Outer null check
            synchronized (this) {
                if (f == null) { // Inner null check
                    f = new Object(); // Field assignment // [REPORTED LINE]
                    otherField = new Object(); // Another assignment after field assignment within synchronized block
                }
            }
        }
        return f;
    }
}