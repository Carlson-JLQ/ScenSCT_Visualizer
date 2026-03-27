// Binary expression that is a constant condition used as condition of if whose then block throws ConcurrentModificationException should not be flagged.
package scensct.var.neg;

import java.util.ConcurrentModificationException;

public class NegCase5_Var2 {
    public static void main(String[] args) {
        boolean a = true;
        boolean b = false;
        // Constant via logical expression
        if (a && !b) {
            throw new ConcurrentModificationException();
        }
    }
}