// Binary expression that is a constant condition used as condition of if whose then block throws ConcurrentModificationException should not be flagged.
package scensct.var.neg;

import java.util.ConcurrentModificationException;

public class NegCase5_Var1 {
    public static void main(String[] args) {
        final boolean alwaysTrue = true;
        // Explicit equality comparison, still constant
        if (alwaysTrue == true) {
            throw new ConcurrentModificationException();
        }
    }
}