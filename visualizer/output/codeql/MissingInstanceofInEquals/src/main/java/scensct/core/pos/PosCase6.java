// equals method without type test and no equality return statement should be flagged as bug.
package scensct.core.pos;

public class PosCase6 {
    @Override
    public boolean equals(Object obj) { // [REPORTED LINE]
        // No type test, and no return statement with equality expression
        return false; // Returns boolean literal, not an equality expression (== or !=)
    }
}