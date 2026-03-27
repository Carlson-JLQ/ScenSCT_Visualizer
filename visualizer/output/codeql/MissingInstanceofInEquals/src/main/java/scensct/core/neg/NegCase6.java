// equals method passing parameter to abstract method should not be flagged as missing type test
package scensct.core.neg;

public class NegCase6 {
    @Override
    public boolean equals(Object obj) {
        // Scenario 6: parameter passed to abstract method (no body)
        performAbstractCheck(obj);
        return false; // Default return for scenario clarity
    }
    
    private native void performAbstractCheck(Object obj); // Native method, no body
}