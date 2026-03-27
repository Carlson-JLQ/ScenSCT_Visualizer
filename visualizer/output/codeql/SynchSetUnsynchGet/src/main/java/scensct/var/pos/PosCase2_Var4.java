// A class with synchronized setter and unsynchronized getter, volatile field exists but getter accesses non-volatile field should be flagged as unsynchronized getter.
package scensct.var.pos;

public class PosCase2_Var4 {
    private int value;
    private volatile int flag;

    public synchronized void setValue(int v) {
        if (v >= 0) {
            value = v;
        } else {
            value = 0; // control flow variation
        }
    }

    public int getValue() { // [REPORTED LINE]
        if (flag == 0) { // reads volatile, but still returns non-volatile 'value'
            return value;
        }
        return value; // same path
    }
}