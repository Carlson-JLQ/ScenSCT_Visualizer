// equals method without type test returns equality between two literals should be flagged as bug.
package scensct.var.pos;

public class PosCase3_Var1 {
    @Override
    public boolean equals(Object other) { // [REPORTED LINE]
        // Same bug: no instanceof, returns literal comparison
        boolean result = (5 * 2) == 10;
        return result;
    }
}