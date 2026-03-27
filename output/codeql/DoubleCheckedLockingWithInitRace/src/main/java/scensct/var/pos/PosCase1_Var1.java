// Double-checked locking with assignment to another field after the field assignment should be flagged as potential race condition.
package scensct.var.pos;

public class PosCase1_Var1 {
    private Object data;
    private Object secondary;

    public Object getF() {
        Object local = data;
        if (local == null) {
            synchronized (this) {
                local = data;
                if (local == null) {
                    data = new Object(); // [REPORTED LINE]
                    secondary = new Object();
                }
            }
        }
        return data;
    }
}