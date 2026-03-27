// equals method using instanceof on parameter should not be flagged as missing type test
package scensct.core.neg;

public class NegCase2 {
    @Override
    public boolean equals(Object obj) {
        // Scenario 2: instanceof test on parameter before operations
        if (!(obj instanceof NegCase2)) {
            return false;
        }
        NegCase2 other = (NegCase2) obj;
        return true; // Simplified equality logic
    }
}