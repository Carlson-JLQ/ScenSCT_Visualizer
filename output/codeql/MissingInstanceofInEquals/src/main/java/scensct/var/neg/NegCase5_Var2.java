// equals method delegating type test to another method should not be flagged as missing type test
package scensct.var.neg;

public class NegCase5_Var2 {
    @Override
    public boolean equals(Object obj) {
        // Variant 2: type check via static helper method
        if (!NegCase5_Var2.isCorrectType(obj)) {
            return false;
        }
        NegCase5_Var2 other = (NegCase5_Var2) obj;
        return true;
    }
    
    private static boolean isCorrectType(Object obj) {
        return obj instanceof NegCase5_Var2;
    }
}