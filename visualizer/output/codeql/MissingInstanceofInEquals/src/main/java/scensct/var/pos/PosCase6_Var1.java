// equals method without type test and no equality return statement should be flagged as bug.
package scensct.var.pos;

public class PosCase6_Var1 {
    @Override
    public boolean equals(Object obj) { // [REPORTED LINE]
        if (obj == null) {
            return false;
        }
        // Still no instanceof, and no equality expression
        boolean result = false;
        return result;
    }
}