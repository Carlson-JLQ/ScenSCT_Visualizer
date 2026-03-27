// Binary expression that is a constant condition used as condition of if whose then block throws ConcurrentModificationException should not be flagged.
package scensct.var.neg;

import java.util.ConcurrentModificationException;

public class NegCase5_Var4 {
    public static void main(String[] args) {
        boolean flag = true;
        // Wrap in try-catch but keep the if-throw structure
        try {
            if (flag) {
                throw new ConcurrentModificationException();
            }
        } catch (ConcurrentModificationException e) {
            // Rethrow to preserve behavior
            throw e;
        }
    }
}