// equals method without type test and no equality return statement should be flagged as bug.
package scensct.var.pos;

public class PosCase6_Var5 {
    @Override
    public boolean equals(Object obj) { // [REPORTED LINE]
        return helper();
    }

    private boolean helper() {
        // No type test, no equality expression
        return false;
    }
}