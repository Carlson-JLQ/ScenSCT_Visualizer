// equals method without type test returns equality between parameter and another parameter should be flagged as bug.
package scensct.core.pos;

public class PosCase5 {
    @Override
    public boolean equals(Object obj) { // [REPORTED LINE]
        // No type test, returns equality: parameter access vs local variable access
        final Object local = new Object();
        return obj == local; // obj is parameter, local is local variable (not this, not field)
    }
}