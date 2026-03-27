// equals method performs checked cast on parameter without preceding type test should be flagged as bug.
package scensct.var.pos;

public class PosCase8_Var1 {
    @Override
    public boolean equals(Object obj) { // [REPORTED LINE]
        // Variant 1: Introduce a temporary variable and early return pattern
        if (obj == null) {
            return false;
        }
        // Cast without type test, but now after a null check
        PosCase8_Var1 target = (PosCase8_Var1) obj;
        return target != null; // Always true for non-null, but preserves cast
    }
}