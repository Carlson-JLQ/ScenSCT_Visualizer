// equals method without type test and no equality return statement should be flagged as bug.
package scensct.var.pos;

public class PosCase6_Var2 {
    @Override
    public boolean equals(Object obj) { // [REPORTED LINE]
        try {
            // No type test, no equality expression
            return Boolean.FALSE;
        } catch (Exception e) {
            return false;
        }
    }
}