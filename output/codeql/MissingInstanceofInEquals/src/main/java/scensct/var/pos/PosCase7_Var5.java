// equals method uses class expression involving parameter without proper type test should be flagged as bug.
package scensct.var.pos;

public class PosCase7_Var5 {
    @Override
    public boolean equals(Object obj) { // [REPORTED LINE]
        // Restructure with if-else, dead else branch
        if (PosCase7_Var5.class == obj) {
            return true;
        } else {
            return false;
        }
    }
}