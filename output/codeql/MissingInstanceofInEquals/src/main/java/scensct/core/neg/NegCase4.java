// equals method using safe cast (pattern variable) on parameter should not be flagged as missing type test
package scensct.core.neg;

public class NegCase4 {
    @Override
    public boolean equals(Object obj) {
        // Scenario 4: safe cast expression with pattern variable
        if (obj instanceof NegCase4 other) {
            return true; // Simplified equality logic using 'other'
        }
        return false;
    }
}