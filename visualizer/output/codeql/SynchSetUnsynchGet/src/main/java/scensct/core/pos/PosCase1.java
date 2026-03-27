// A class with synchronized setter and unsynchronized getter, no volatile fields should be flagged as unsynchronized getter.
package scensct.core.pos;

public class PosCase1 {
    private int value;

    public synchronized void setValue(int v) {
        value = v;
    }

    public int getValue() { // Unsynchronized getter, no volatile field // [REPORTED LINE]
        return value;
    }
}