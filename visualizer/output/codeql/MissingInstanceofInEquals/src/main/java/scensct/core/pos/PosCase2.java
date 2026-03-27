// equals method without type test returns equality between parameter and 'this' should be flagged as bug.
package scensct.core.pos;

public class PosCase2 {
    @Override
    public boolean equals(Object obj) {
        // No type test, returns simple equality: parameter vs 'this'
        return obj == this; // Direct comparison of parameter to 'this'
    }
}