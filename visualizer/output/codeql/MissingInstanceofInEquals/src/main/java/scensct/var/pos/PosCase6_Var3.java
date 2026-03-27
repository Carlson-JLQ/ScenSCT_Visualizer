// equals method without type test and no equality return statement should be flagged as bug.
package scensct.var.pos;

public class PosCase6_Var3 {
    @Override
    public boolean equals(Object obj) { // [REPORTED LINE]
        int dummy = 0;
        switch (dummy) {
            case 0:
                return false;
            default:
                return true;
        }
        // No instanceof, no equality expression
    }
}