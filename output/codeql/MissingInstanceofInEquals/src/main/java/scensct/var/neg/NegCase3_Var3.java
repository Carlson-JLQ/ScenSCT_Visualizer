// equals method using not instanceof on parameter should not be flagged as missing type test
package scensct.var.neg;

public class NegCase3_Var3 {
    @Override
    public boolean equals(Object obj) {
        // Variant 3: Extracted type test to a helper method
        if (!isInstanceOfThis(obj)) {
            return false;
        }
        NegCase3_Var3 other = (NegCase3_Var3) obj;
        return true; // Simplified equality logic
    }

    private boolean isInstanceOfThis(Object obj) {
        return obj instanceof NegCase3_Var3;
    }
}