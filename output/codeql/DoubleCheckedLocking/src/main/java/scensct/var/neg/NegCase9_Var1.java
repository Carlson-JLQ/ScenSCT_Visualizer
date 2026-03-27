// A method implementing double-checked locking with volatile field should not be flagged as unsafe.
package scensct.var.neg;

public class NegCase9_Var1 {
    private volatile String data; // volatile field, type changed

    public void method() {
        final Object lock = this; // alias for synchronized object
        if (data == null) {
            synchronized (lock) {
                if (data == null) {
                    data = "initialized";
                }
            }
        }
    }
}