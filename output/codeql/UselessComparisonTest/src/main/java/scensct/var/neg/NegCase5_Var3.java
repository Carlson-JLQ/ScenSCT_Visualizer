// Binary expression that is a constant condition used as condition of if whose then block throws ConcurrentModificationException should not be flagged.
package scensct.var.neg;

import java.util.ConcurrentModificationException;

public class NegCase5_Var3 {
    public static void main(String[] args) {
        boolean flag = true;
        // Introduce temporary variable to obscure direct use
        boolean condition = flag;
        if (condition) {
            // Throw inside a helper call
            throwConcurrentModEx();
        }
    }
    
    private static void throwConcurrentModEx() {
        throw new ConcurrentModificationException();
    }
}