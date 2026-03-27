// equals method using getClass() on parameter should not be flagged as missing type test
package scensct.core.neg;

public class NegCase1 {
    @Override
    public boolean equals(Object obj) {
        // Scenario 1: getClass() call on parameter for type comparison
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        NegCase1 other = (NegCase1) obj;
        return true; // Simplified equality logic
    }
}