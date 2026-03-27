// A method with inner if condition not being == null check should not be flagged as double-checked locking.
package scensct.var.neg;

public class NegCase6_Var4 {
    private Object f;

    private boolean innerCheck(Object local) {
        return f == local; // extracted inner condition
    }

    public void method() {
        if (f == null) {
            synchronized (this) {
                Object local = new Object();
                if (innerCheck(local)) { // inner condition via helper method
                    f = new Object();
                }
            }
        }
    }
}