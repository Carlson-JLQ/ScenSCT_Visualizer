// A non-final/static/volatile field with a non-thread-safe declared type in a @ThreadSafe class, with no initializer, assigned a non-default value (non-null/non-zero) in the constructor or initializer should be flagged as unsafe publication.
package scensct.var.pos;

import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public class PosCase3_Var2 {
    private java.util.HashMap<String, Integer> map; // [REPORTED LINE]

    public PosCase3_Var2() {
        // Assignment via a temporary variable
        java.util.HashMap<String, Integer> tmp = new java.util.HashMap<>();
        // Irrelevant if-else that doesn't affect assignment
        if (System.currentTimeMillis() > 0) {
            map = tmp;
        } else {
            map = tmp; // same branch, just to complicate control flow
        }
    }
}