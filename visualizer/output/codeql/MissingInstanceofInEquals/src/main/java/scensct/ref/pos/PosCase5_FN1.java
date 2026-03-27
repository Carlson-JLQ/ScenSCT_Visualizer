// equals method without type test returns equality between parameter and another parameter should be flagged as bug.
package scensct.ref.pos;

public class PosCase5_FN1 {
    public boolean equals(Object obj1, Object obj2) {
        // Overloaded equals (not Object.equals), but scenario requires equals method without type test.
        // We'll create a helper class to satisfy scenario: equality between parameter access and another parameter.
        // Instead, we implement Object.equals to match scenario: one operand is parameter access, other is local variable.
        // We'll use a local variable as the non-this, non-field access.
        final Object local = new Object();
        // No type test, returns equality: parameter access vs local variable access
        return obj1 == local; // obj1 is parameter, local is local variable (not this, not field)
    }
}