// equals method using not instanceof on parameter should not be flagged as missing type test
package scensct.var.neg;

public class NegCase3_Var4 {
    @Override
    public boolean equals(Object obj) {
        // Variant 4: Type test inside a try-catch block (no exception thrown)
        try {
            if (!(obj instanceof NegCase3_Var4)) {
                return false;
            }
        } catch (Exception e) {
            // Never reached, but adds control flow complexity
            return false;
        }
        NegCase3_Var4 other = (NegCase3_Var4) obj;
        return true; // Simplified equality logic
    }
}