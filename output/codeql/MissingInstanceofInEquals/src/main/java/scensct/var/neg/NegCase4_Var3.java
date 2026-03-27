// equals method using safe cast (pattern variable) on parameter should not be flagged as missing type test
package scensct.var.neg;

public class NegCase4_Var3 {
    @Override
    public boolean equals(Object obj) {
        // Variant 3: pattern variable used in a method call to demonstrate type safety
        if (obj instanceof NegCase4_Var3 other) {
            return checkEquality(other);
        }
        return false;
    }

    private boolean checkEquality(NegCase4_Var3 other) {
        // Dummy equality check
        return other != null;
    }
}