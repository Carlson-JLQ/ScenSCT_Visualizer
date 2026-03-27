// A non-final/static/volatile field with a non-thread-safe declared type in a @ThreadSafe class, with no initializer, assigned a non-default value (non-null/non-zero) in the constructor or initializer should be flagged as unsafe publication.
package scensct.var.pos;

import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public class PosCase3_Var3 {
    private java.util.HashMap<String, Integer> map; // [REPORTED LINE]

    public PosCase3_Var3() {
        // Wrapped in try-catch but assignment still happens
        try {
            map = new java.util.HashMap<>();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}