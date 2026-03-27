// equals method without type test returns equality between two fields (not parameter) should be flagged as bug.
package scensct.core.pos;

public class PosCase4 {
    private int a = 1;
    private int b = 2;

    @Override
    public boolean equals(Object obj) { // [REPORTED LINE]
        // No type test, returns equality between two fields, neither is parameter
        return a == b; // Both operands are field accesses, not involving parameter
    }
}