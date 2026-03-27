// A class with synchronized setter and getter with incorrect lock object, volatile field exists but getter accesses non-volatile field should be flagged as unsynchronized getter.
package scensct.var.pos;

public class PosCase3_Var1 {
    private int data; // Renamed field
    private volatile int status; // Renamed volatile field
    private final Object incorrectMonitor = new Object(); // Renamed lock

    public synchronized void assign(int val) { // Renamed method and parameter
        data = val;
    }

    public int retrieve() { // [REPORTED LINE]
        synchronized (incorrectMonitor) {
            return data; // Accesses non-volatile field
        }
    }
}