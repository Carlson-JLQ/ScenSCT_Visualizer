// A method with inner if condition not being == null check should not be flagged as double-checked locking.
package scensct.var.neg;

public class NegCase6_Var1 {
    private Object data; // renamed non-volatile field

    public void initialize() { // renamed method
        if (data == null) {
            synchronized (this) {
                Object temp = new Object();
                if (temp.equals(data)) { // inner condition: equals comparison, not null check
                    data = new Object();
                }
            }
        }
    }
}