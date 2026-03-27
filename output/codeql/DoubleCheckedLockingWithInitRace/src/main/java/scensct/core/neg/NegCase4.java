// Double-checked locking where side-effects in synchronized block are only println calls should not be flagged as a race condition.
package scensct.core.neg;

public class NegCase4 {
    private Object field;

    public Object getField() {
        if (field == null) { // IF1: outer null check
            synchronized (this) {
                if (field == null) { // IF2: inner null check
                    field = new Object();
                    System.out.println("Field initialized"); // Side-effect is println call
                    int local = 5; // Local assignment (not method call/field assignment)
                }
            }
        }
        return field;
    }
}