// A class with synchronized setter and unsynchronized getter, no volatile fields should be flagged as unsynchronized getter.
package scensct.var.pos;

public class PosCase1_Var2 {
    private int value;

    public synchronized void setValue(int v) {
        this.value = v;
    }

    public int getValue() { // [REPORTED LINE]
        int temp = this.value;
        return temp;
    }
}