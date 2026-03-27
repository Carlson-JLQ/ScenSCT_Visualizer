// Double-checked locking on non-volatile, non-immutable field should be flagged as thread-unsafe.
package scensct.var.pos;

public class PosCase1_Var5 {
    private Object instance;

    private void initSingleton() {
        if (instance == null) {
            instance = new Object();
        }
    }

    public Object getInstance() {
        if (instance == null) {
            synchronized (this) {
                // inner check moved into helper but still inside sync
                initSingleton();
            }
        }
        return instance;
    }
}