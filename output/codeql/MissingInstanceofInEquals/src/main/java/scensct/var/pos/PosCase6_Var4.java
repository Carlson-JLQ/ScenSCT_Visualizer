// equals method without type test and no equality return statement should be flagged as bug.
package scensct.var.pos;

public class PosCase6_Var4 {
    @Override
    public boolean equals(Object obj) { // [REPORTED LINE]
        boolean flag = false;
        for (int i = 0; i < 1; i++) {
            flag = true;
        }
        return flag; // still no equality expression, no instanceof
    }
}