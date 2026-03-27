// equals method without type test returns equality between two literals should be flagged as bug.
package scensct.core.pos;

public class PosCase3 {
    @Override
    public boolean equals(Object obj) { // [REPORTED LINE]
        // No type test, returns equality comparison: literal vs literal
        return 1 == 2; // Both operands are literals
    }
}