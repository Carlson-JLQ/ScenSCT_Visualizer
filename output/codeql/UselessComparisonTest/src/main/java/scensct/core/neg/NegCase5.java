// Binary expression that is a constant condition used as condition of if whose then block throws ConcurrentModificationException should not be flagged.
package scensct.core.neg;

import java.util.ConcurrentModificationException;

public class NegCase5 {
    public static void main(String[] args) {
        boolean flag = true;
        // Constant condition (true) but used in if that throws ConcurrentModificationException (excluded by checker)
        if (flag) {
            throw new ConcurrentModificationException();
        }
    }
}