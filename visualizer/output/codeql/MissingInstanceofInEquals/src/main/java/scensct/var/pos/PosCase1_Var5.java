// equals method without type test returns equality between field and literal should be flagged as bug.
package scensct.var.pos;

public class PosCase1_Var5 {
    private int value;

    @Override
    public boolean equals(Object obj) { // [REPORTED LINE]
        // Control-flow with loop (trivial) and expression rewrite
        for (int i = 0; i < 1; i++) {
            return value == 42;
        }
        return false; // unreachable, but preserves structure
    }
}