// A class with synchronized setter and unsynchronized getter, getter accesses volatile field but writes to it are outside synchronized setter should be flagged as unsynchronized getter.
package scensct.var.pos;

public class PosCase5_Var2 {
    private volatile int counter;
    private int value;
    private boolean flag = false; // Added dummy field

    public synchronized void setValue(int v) {
        if (v > 0) { // Added trivial conditional
            value = v;
        } else {
            value = 0;
        }
    }

    public void incrementCounter() {
        int temp = counter; // Introduce temporary
        counter = temp + 1;
    }

    public int getValue() { // [REPORTED LINE]
        int result = value; // Use temporary in getter
        return result;
    }

    public int getCounter() {
        return counter;
    }
}