// equals method using safe cast (pattern variable) on parameter should not be flagged as missing type test
package scensct.var.neg;

public class NegCase4_Var1 {
    @Override
    public boolean equals(Object obj) {
        // Variant 1: pattern variable used in a conditional return with explicit boolean variable
        boolean isEqual = false;
        if (obj instanceof NegCase4_Var1 other) {
            isEqual = true; // Using 'other' implicitly (just presence)
        }
        return isEqual;
    }
}