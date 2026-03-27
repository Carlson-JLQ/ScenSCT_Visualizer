// equals method without type test returns equality between two literals should be flagged as bug.
package scensct.var.pos;

public class PosCase3_Var4 {
    private boolean alwaysFalse() {
        return 0 == 1;
    }

    @Override
    public boolean equals(Object obj) { // [REPORTED LINE]
        // Delegate to helper method; helper also lacks type test
        return alwaysFalse();
    }
}