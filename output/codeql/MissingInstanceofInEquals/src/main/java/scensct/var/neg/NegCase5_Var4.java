// equals method delegating type test to another method should not be flagged as missing type test
package scensct.var.neg;

public class NegCase5_Var4 {
    @Override
    public boolean equals(Object obj) {
        // Variant 4: nested method call for type check (two-level delegation)
        if (!validateInstance(obj)) {
            return false;
        }
        NegCase5_Var4 other = (NegCase5_Var4) obj;
        return true;
    }
    
    private boolean validateInstance(Object obj) {
        return isInstanceOfThisClass(obj);
    }
    
    private boolean isInstanceOfThisClass(Object obj) {
        return obj instanceof NegCase5_Var4;
    }
}