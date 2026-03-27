// Double-checked locking where inner if's condition reads field via a method call should not be flagged as a race condition.
package scensct.var.neg;

public class NegCase1_Var5 {
    private Object field;
    private final Object lock = new Object();

    public Object getField() {
        // Variant 5: Change sync object, add harmless side-effect print, inner via method
        if (field == null) {
            synchronized (lock) {
                if (getField() == null) {
                    field = new Object();
                    System.out.println("Initialized field");
                }
            }
        }
        return field;
    }
}