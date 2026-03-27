// A class with synchronized setter and unsynchronized getter, getter accesses volatile field but writes to it are outside synchronized setter should be flagged as unsynchronized getter.
package scensct.var.pos;

public class PosCase5_Var5 {
    private volatile int counter;
    private int value;

    public synchronized void setValue(int v) {
        this.value = v; // Use 'this'
    }

    public void incrementCounter() {
        modifyCounter(); // Inter-procedural call
    }

    private void modifyCounter() { // Extracted logic
        counter = counter + 1;
    }

    public int getValue() { // [REPORTED LINE]
        return this.value; // Use 'this'
    }

    public int getCounter() {
        return counter;
    }
}