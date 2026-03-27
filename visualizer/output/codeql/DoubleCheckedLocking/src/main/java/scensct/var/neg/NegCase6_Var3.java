// A method with inner if condition not being == null check should not be flagged as double-checked locking.
package scensct.var.neg;

public class NegCase6_Var3 {
    private Object f;

    public void method() {
        boolean isNull = f == null;
        if (isNull) { // outer null check via temporary variable
            synchronized (this) {
                Object local = new Object();
                boolean same = f == local; // compute condition separately
                if (same) { // inner condition still not f == null
                    f = new Object();
                }
            }
        }
    }
}