// Inner if condition is not an equality test should not be flagged as a race condition.
package scensct.core.neg;

public class NegCase7 {
    private Object field;
    private boolean flag = true;

    public Object getField() {
        if (field == null) { // IF1: outer null check
            synchronized (this) {
                if (flag) { // IF2: condition is not equality test (boolean variable)
                    field = new Object();
                }
            }
        }
        return field;
    }
}