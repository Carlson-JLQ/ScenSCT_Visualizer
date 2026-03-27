// equals method delegating type test to another method should not be flagged as missing type test
package scensct.var.neg;

public class NegCase5_Var3 {
    @Override
    public boolean equals(Object obj) {
        // Variant 3: store result of type check in variable, then branch
        boolean typeOk = checkType(obj);
        if (!typeOk) {
            return false;
        }
        NegCase5_Var3 other = (NegCase5_Var3) obj;
        return true;
    }
    
    private boolean checkType(Object obj) {
        return obj != null && obj.getClass() == NegCase5_Var3.class;
    }
}