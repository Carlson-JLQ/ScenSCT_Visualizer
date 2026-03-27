// equals method delegating type test to another method should not be flagged as missing type test
package scensct.core.neg;

public class NegCase5 {
    @Override
    public boolean equals(Object obj) {
        // Scenario 5: parameter passed to method performing instanceof test
        if (!isInstanceOfThisClass(obj)) {
            return false;
        }
        NegCase5 other = (NegCase5) obj;
        return true; // Simplified equality logic
    }
    
    private boolean isInstanceOfThisClass(Object obj) {
        return obj instanceof NegCase5;
    }
}