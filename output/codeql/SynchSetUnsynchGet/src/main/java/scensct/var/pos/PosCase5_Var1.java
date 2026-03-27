// A class with synchronized setter and unsynchronized getter, getter accesses volatile field but writes to it are outside synchronized setter should be flagged as unsynchronized getter.
package scensct.var.pos;

public class PosCase5_Var1 {
    private volatile int count; // Renamed volatile field
    private int data; // Renamed non-volatile field

    public synchronized void assignData(int val) { // Renamed method and parameter
        this.data = val; // Explicit 'this', same non-volatile write
    }

    public void bumpCount() { // Renamed method, writes to volatile
        count += 1; // Different increment expression
    }

    public int retrieveData() { // Unsynchronized getter, renamed
        return data; // Accesses non-volatile field
    }

    public int fetchCount() { // Accesses volatile field, renamed
        return count;
    }
}