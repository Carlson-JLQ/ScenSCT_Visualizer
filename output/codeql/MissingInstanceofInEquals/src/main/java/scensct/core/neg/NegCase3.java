// equals method using not instanceof on parameter should not be flagged as missing type test
package scensct.core.neg;

public class NegCase3 {
    @Override
    public boolean equals(Object obj) {
        // Scenario 3: not instanceof expression for type test
        if (obj instanceof NegCase3) {
            NegCase3 other = (NegCase3) obj;
            return true; // Simplified equality logic
        }
        return false;
    }
}