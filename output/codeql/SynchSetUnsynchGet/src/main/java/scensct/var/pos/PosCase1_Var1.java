// A class with synchronized setter and unsynchronized getter, no volatile fields should be flagged as unsynchronized getter.
package scensct.var.pos;

public class PosCase1_Var1 {
    private int data;

    public synchronized void assignData(int newValue) {
        this.data = newValue;
    }

    public int retrieveData() {
        return data;
    }
}