// A method implementing double-checked locking on non-volatile field of immutable type should not be flagged as unsafe.
package scensct.var.neg;

public class NegCase10_Var1 {
    private String data; // renamed field, still non-volatile and immutable

    public void initialize() { // renamed method
        if (data == null) {
            synchronized (this) {
                if (data == null) {
                    data = "default"; // different literal
                }
            }
        }
    }
}