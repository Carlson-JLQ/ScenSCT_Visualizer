// equals method using instanceof on parameter should not be flagged as missing type test
package scensct.var.neg;

public class NegCase2_Var1 {
    @Override
    public boolean equals(Object obj) {
        // Positive condition first
        if (obj instanceof NegCase2_Var1) {
            NegCase2_Var1 other = (NegCase2_Var1) obj;
            return true;
        }
        return false;
    }
}