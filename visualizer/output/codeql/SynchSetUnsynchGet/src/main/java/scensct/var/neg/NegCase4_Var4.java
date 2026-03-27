// A class with correctly named getter/setter pair where setter is synchronized and getter uses synchronized block should not be flagged as unsynchronized getter with synchronized setter.
package scensct.var.neg;

public class NegCase4_Var4 {
    private int value;
    private final Object lock = new Object();

    // Setter synchronized on same private lock
    public void setValue(int v) {
        synchronized (lock) {
            value = v;
        }
    }

    // Getter also synchronized on same private lock
    public int getValue() {
        synchronized (lock) {
            return value;
        }
    }
}