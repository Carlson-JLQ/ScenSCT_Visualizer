// A non-final/static/volatile field with a non-thread-safe declared type in a @ThreadSafe class, with no initializer, assigned a non-default value (non-null/non-zero) in the constructor or initializer should be flagged as unsafe publication.
package scensct.var.pos;

import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public class PosCase3_Var5 {
    private java.util.HashMap<String, Integer> map;

    // Instance initializer instead of constructor assignment
    {
        map = new java.util.HashMap<>();
    }

    public PosCase3_Var5() {
        // Constructor may be empty or have other logic
    }
}