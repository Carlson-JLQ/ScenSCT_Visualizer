// equals method without type test returns equality between two literals should be flagged as bug.
package scensct.var.pos;

public class PosCase3_Var3 {
    @Override
    public boolean equals(Object obj) { // [REPORTED LINE]
        // Wrap literal comparison in ternary, still no guard
        return (3 < 4) ? true : false;
    }
}