// A class with synchronized setter and unsynchronized getter, no volatile fields should be flagged as unsynchronized getter.
package scensct.var.pos;

public class PosCase1_Var3 {
    private int value;

    public synchronized void updateValue(int v) {
        value = v;
    }

    private int internalGet() {
        return value;
    }

    public int getValue() {
        return internalGet();
    }
}