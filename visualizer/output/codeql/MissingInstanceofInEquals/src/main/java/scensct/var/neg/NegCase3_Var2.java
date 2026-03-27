// equals method using not instanceof on parameter should not be flagged as missing type test
package scensct.var.neg;

public class NegCase3_Var2 {
    @Override
    public boolean equals(Object obj) {
        // Variant 2: Type test via getClass() with null check
        if (obj == null || obj.getClass() != NegCase3_Var2.class) {
            return false;
        }
        NegCase3_Var2 other = (NegCase3_Var2) obj;
        return true; // Simplified equality logic
    }
}