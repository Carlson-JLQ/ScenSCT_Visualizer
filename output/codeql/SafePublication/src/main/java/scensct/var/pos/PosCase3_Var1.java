// A non-final/static/volatile field with a non-thread-safe declared type in a @ThreadSafe class, with no initializer, assigned a non-default value (non-null/non-zero) in the constructor or initializer should be flagged as unsafe publication.
package scensct.var.pos;

import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public class PosCase3_Var1 {
    private java.util.HashMap<String, Integer> data; // renamed field // [REPORTED LINE]

    public PosCase3_Var1() {
        // Same unsafe publication, but with explicit initial capacity
        data = new java.util.HashMap<>(16);
    }
}