// equals method without type test returns equality between parameter and another parameter should be flagged as bug.
package scensct.var.pos;

public class PosCase5_Var4 {
    @Override
    public boolean equals(Object obj) { // [REPORTED LINE]
        // Variant 4: Wrap in a try-catch-finally, returning from finally.
        final Object local = new Object();
        try {
            // do nothing
        } catch (RuntimeException e) {
            throw e;
        } finally {
            return obj == local;
        }
    }
}