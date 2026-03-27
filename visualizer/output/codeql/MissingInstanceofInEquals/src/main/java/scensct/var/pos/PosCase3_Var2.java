// equals method without type test returns equality between two literals should be flagged as bug.
package scensct.var.pos;

public class PosCase3_Var2 {
    @Override
    public boolean equals(Object obj) { // [REPORTED LINE]
        // Introduce temporary and early return, but still no type test
        final int x = 100;
        final int y = 200;
        if (x != y) {
            return false;
        }
        return true; // unreachable, but pattern preserved
    }
}