// equals method using safe cast (pattern variable) on parameter should not be flagged as missing type test
package scensct.var.neg;

public class NegCase4_Var4 {
    @Override
    public boolean equals(Object obj) {
        // Variant 4: pattern variable with additional condition in the pattern
        if (obj instanceof NegCase4_Var4 other && other.hashCode() == this.hashCode()) {
            return true;
        }
        return false;
    }
}