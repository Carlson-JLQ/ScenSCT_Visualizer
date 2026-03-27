// A class with correctly named getter/setter pair accessing a volatile field should not be flagged as unsynchronized getter with synchronized setter.
package scensct.var.neg;

public class NegCase6_Var1 {
    private volatile int data; // renamed field, still volatile

    public synchronized void setValue(int v) {
        data = v; // assignment to volatile field
    }

    public int getValue() {
        return data; // direct read of volatile
    }
}