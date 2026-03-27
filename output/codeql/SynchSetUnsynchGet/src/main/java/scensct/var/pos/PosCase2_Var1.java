// A class with synchronized setter and unsynchronized getter, volatile field exists but getter accesses non-volatile field should be flagged as unsynchronized getter.
package scensct.var.pos;

public class PosCase2_Var1 {
    private int data; // renamed from 'value'
    private volatile int flag;

    public synchronized void setValue(int v) {
        this.data = v; // using 'this' qualifier
    }

    public int getValue() { // still unsynchronized // [REPORTED LINE]
        return data; // accesses renamed field
    }
}