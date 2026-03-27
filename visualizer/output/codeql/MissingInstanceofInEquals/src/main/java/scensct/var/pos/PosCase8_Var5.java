// equals method performs checked cast on parameter without preceding type test should be flagged as bug.
package scensct.var.pos;

public class PosCase8_Var5 {
    @Override
    public boolean equals(Object obj) { // [REPORTED LINE]
        // Variant 5: Add irrelevant statements and cast via assignment expression
        boolean flag = false;
        flag = (obj != null);
        PosCase8_Var5 other = flag ? (PosCase8_Var5) obj : null; // Cast without type test in ternary
        return other == other; // Always true if cast succeeds
    }
}