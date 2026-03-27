// Double-checked locking where side-effects in synchronized block are only println calls should not be flagged as a race condition.
package scensct.var.neg;

public class NegCase4_Var1 {
    private String cached;

    public String getCached() {
        if (cached == null) {
            synchronized (this) {
                if (cached == null) {
                    cached = new String("Initialized");
                    int temp = 10;
                    System.out.println("Cached string created");
                }
            }
        }
        return cached;
    }
}