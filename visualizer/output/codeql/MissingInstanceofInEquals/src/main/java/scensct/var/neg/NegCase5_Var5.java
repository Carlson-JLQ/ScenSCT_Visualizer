// equals method delegating type test to another method should not be flagged as missing type test
package scensct.var.neg;

public class NegCase5_Var5 {
    @Override
    public boolean equals(Object obj) {
        // Variant 5: try-catch around cast after delegated check (defensive but still safe)
        if (!isInstanceOfThisClass(obj)) {
            return false;
        }
        try {
            NegCase5_Var5 other = (NegCase5_Var5) obj;
            return true;
        } catch (ClassCastException e) {
            // Should never happen due to the check above
            return false;
        }
    }
    
    private boolean isInstanceOfThisClass(Object obj) {
        return obj instanceof NegCase5_Var5;
    }
}