// equals method using not instanceof on parameter should not be flagged as missing type test
package scensct.var.neg;

public class NegCase3_Var1 {
    @Override
    public boolean equals(Object obj) {
        // Variant 1: Inverted logic with early return
        if (!(obj instanceof NegCase3_Var1)) {
            return false;
        }
        NegCase3_Var1 other = (NegCase3_Var1) obj;
        return true; // Simplified equality logic
    }
}