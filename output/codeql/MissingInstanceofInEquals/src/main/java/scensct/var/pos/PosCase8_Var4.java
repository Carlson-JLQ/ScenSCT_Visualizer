// equals method performs checked cast on parameter without preceding type test should be flagged as bug.
package scensct.var.pos;

public class PosCase8_Var4 {
    @Override
    public boolean equals(Object obj) { // [REPORTED LINE]
        // Variant 4: Control flow with loop (unrolled) that still casts
        for (int i = 0; i < 1; i++) {
            PosCase8_Var4 other = (PosCase8_Var4) obj;
            return true;
        }
        return false; // Unreachable, but preserves structure
    }
}