// A class with synchronized setter and unsynchronized getter, no volatile fields should be flagged as unsynchronized getter.
package scensct.var.pos;

public class PosCase1_Var5 {
    private int value;

    public synchronized void setValue(int v) {
        value = v;
    }

    public int getValue() { // [REPORTED LINE]
        try {
            return value;
        } finally {
            // No-op, just to add control flow
        }
    }
}