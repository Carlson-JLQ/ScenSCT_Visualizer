// equals method delegating type test to another method should not be flagged as missing type test
package scensct.var.neg;

public class NegCase5_Var1 {
    @Override
    public boolean equals(Object obj) {
        // Variant 1: early return with inverted logic, helper call in condition
        if (isInstanceOfThisClass(obj)) {
            NegCase5_Var1 other = (NegCase5_Var1) obj;
            return true;
        }
        return false;
    }
    
    private boolean isInstanceOfThisClass(Object obj) {
        return obj instanceof NegCase5_Var1;
    }
}