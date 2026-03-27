// A class with synchronized setter and unsynchronized getter, no volatile fields should be flagged as unsynchronized getter.
package scensct.var.pos;

public class PosCase1_Var4 {
    private int value;

    public synchronized void setValue(int v) {
        if (v >= 0) {
            value = v;
        } else {
            value = 0;
        }
    }

    public int getValue() { // [REPORTED LINE]
        return value;
    }
}