// A non-final/static/volatile field with a non-thread-safe declared type in a @ThreadSafe class, with no initializer, assigned a non-default value (non-null/non-zero) in the constructor or initializer should be flagged as unsafe publication.
package scensct.core.pos;

import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public class PosCase3 {
    // Non-final, non-static, non-volatile field with non-thread-safe type (HashMap)
    private java.util.HashMap<String, Integer> map; // No initializer // [REPORTED LINE]

    public PosCase3() {
        // Assignment of non-default value in constructor - unsafe publication
        map = new java.util.HashMap<>();
    }
}