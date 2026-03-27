// equals method using not instanceof on parameter should not be flagged as missing type test
package scensct.var.neg;

public class NegCase3_Var5 {
    @Override
    public boolean equals(Object obj) {
        // Variant 5: Type test with temporary variable and no explicit cast
        boolean isCorrectType = obj instanceof NegCase3_Var5;
        if (!isCorrectType) {
            return false;
        }
        // Cast is still required for usage, but done later
        NegCase3_Var5 other = (NegCase3_Var5) obj;
        return true; // Simplified equality logic
    }
}