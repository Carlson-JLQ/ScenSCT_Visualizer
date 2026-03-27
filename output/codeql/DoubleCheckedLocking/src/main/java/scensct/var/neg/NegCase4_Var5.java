// A method with outer if null check on a different field should not be flagged as double-checked locking on field f.
package scensct.var.neg;

public class NegCase4_Var5 {
    private Object data; // will be initialized inside sync
    private Object guard; // used for outer check

    public void method() {
        if (guard == null) { // still checking the other field
            synchronized (this) {
                if (data == null) {
                    data = new Object();
                }
            }
        }
    }
}