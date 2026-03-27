// Binary expression that is a constant condition used as condition of if whose then block throws ConcurrentModificationException should not be flagged.
package scensct.var.neg;

import java.util.ConcurrentModificationException;

public class NegCase5_Var5 {
    public static void main(String[] args) {
        // Use ternary to produce constant boolean, then if-throw
        boolean flag = args.length < 0 ? false : true; // always true // [REPORTED LINE]
        if (flag) {
            throw new ConcurrentModificationException();
        }
    }
}