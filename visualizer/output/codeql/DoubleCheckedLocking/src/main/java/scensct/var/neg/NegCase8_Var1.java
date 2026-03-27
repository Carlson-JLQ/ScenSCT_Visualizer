// A method with null check on f inside synchronized block but not as inner if condition should not be flagged as double-checked locking.
package scensct.var.neg;

public class NegCase8_Var1 {
    private Object data; // renamed field

    public void method() {
        // outer null check preserved
        if (data == null) {
            synchronized (this) {
                // compute null check via method call
                boolean isNull = computeNull();
                if (isNull) {
                    data = new Object();
                }
            }
        }
    }

    private boolean computeNull() {
        return data == null;
    }
}