// A class with synchronized setter and unsynchronized getter, volatile field exists but getter accesses non-volatile field should be flagged as unsynchronized getter.
package scensct.var.pos;

public class PosCase2_Var2 {
    private int value;
    private volatile int flag;

    public synchronized void setValue(int v) {
        value = v;
        flag = 0; // volatile field used in setter, but getter still doesn't access it
    }

    public int getValue() { // [REPORTED LINE]
        int temp = value; // introduce temporary variable
        return temp;
    }
}