// A local variable assigned a possibly null value is dereferenced inside a conditional block that checks for null without a non-null guard should be flagged as always null dereference.
package scensct.var.pos;

import java.util.Optional;

public class PosCase2_Var5 {
    public static void main(String[] args) {
        Object obj = getPossiblyNull();
        // Use Optional idiomatically, but still dereference inside ifPresent on empty Optional
        Optional<Object> opt = Optional.ofNullable(obj);
        if (!opt.isPresent()) { // Equivalent to obj == null
            obj.toString();
        }
    }
    
    private static Object getPossiblyNull() {
        return null;
    }
}