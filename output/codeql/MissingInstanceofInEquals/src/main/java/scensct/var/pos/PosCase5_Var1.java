// equals method without type test returns equality between parameter and another parameter should be flagged as bug.
package scensct.var.pos;

public class PosCase5_Var1 {
    @Override
    public boolean equals(Object obj) { // [REPORTED LINE]
        // Variant 1: Introduce a temporary variable and a conditional block that doesn't affect the return.
        final Object local = new Object();
        boolean result;
        if (local != null) { // trivial condition, always true
            result = obj == local;
        } else {
            result = false; // dead branch
        }
        return result;
    }
}