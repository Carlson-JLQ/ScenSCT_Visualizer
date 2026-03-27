// Double-checked locking with no side-effects besides assignment in synchronized block should not be flagged as a race condition.
package scensct.var.neg;

public class NegCase2_Var1 {
    private volatile Object data; // renamed field, added volatile (still no side-effects)

    public Object getField() {
        Object local = data; // read into local variable for potential performance
        if (local == null) {
            synchronized (this) {
                local = data;
                if (local == null) {
                    data = new Object(); // assignment only
                }
            }
        }
        return data;
    }
}