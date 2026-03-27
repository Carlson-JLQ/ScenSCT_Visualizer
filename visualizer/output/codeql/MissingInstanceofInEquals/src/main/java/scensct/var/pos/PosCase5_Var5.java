// equals method without type test returns equality between parameter and another parameter should be flagged as bug.
package scensct.var.pos;

public class PosCase5_Var5 {
    @Override
    public boolean equals(Object obj) { // [REPORTED LINE]
        // Variant 5: Use a ternary operator with a trivial condition.
        final Object local = new Object();
        return (local.hashCode() >= 0) ? obj == local : obj == local; // both branches same
    }
}