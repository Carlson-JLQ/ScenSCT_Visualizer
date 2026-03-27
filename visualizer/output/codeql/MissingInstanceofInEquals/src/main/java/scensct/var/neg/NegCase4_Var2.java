// equals method using safe cast (pattern variable) on parameter should not be flagged as missing type test
package scensct.var.neg;

public class NegCase4_Var2 {
    @Override
    public boolean equals(Object obj) {
        // Variant 2: early return with pattern variable, but logic inverted
        if (!(obj instanceof NegCase4_Var2 other)) {
            return false;
        }
        // 'other' is in scope here, though not used
        return true;
    }
}